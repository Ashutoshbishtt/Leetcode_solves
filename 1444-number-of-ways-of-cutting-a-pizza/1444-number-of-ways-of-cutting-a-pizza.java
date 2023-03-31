class Solution {
    String pizza[];
    private static final int kmod = 1000000007;
    int dp[][][];

    public int ways(String[] pizza, int k) {
        int m = pizza.length - 1;
        int n = pizza[0].length() - 1;

        dp = new int[m + 1][n + 1][k];
        for (int[][] A : dp) Arrays.stream(A).forEach(a -> Arrays.fill(a, -1));

        this.pizza = pizza;

        return dfs(0, 0, k - 1, m, n);
    }

    public int dfs(int row, int col, int k, int m, int n) {
        if (k == 0) {
            return 1;
        }

        if (dp[row][col][k] >= 0) return dp[row][col][k];

        dp[row][col][k] = 0;
        for (int i = row; i <= m; i++) {
            if (containsApple(row, i, col, n) && containsApple(i + 1, m, col, n)) {
                dp[row][col][k] = (dp[row][col][k] + dfs(i + 1, col, k - 1, m, n)) % kmod;
            }
        }

        for (int j = col; j <= n; j++) {
            if (containsApple(row, m, col, j) && containsApple(row, m, j + 1, n)) {
                dp[row][col][k] = (dp[row][col][k] + dfs(row, j + 1, k - 1, m, n)) % kmod;
            }
        }

        return dp[row][col][k];
    }

    public boolean containsApple(int rs, int re, int cs, int ce) {
        for (int i = rs; i <= re; i++) {
            for (int j = cs; j <= ce; j++) {
                if (pizza[i].charAt(j) == 'A') return true;
            }
        }
        return false;
    }
}
