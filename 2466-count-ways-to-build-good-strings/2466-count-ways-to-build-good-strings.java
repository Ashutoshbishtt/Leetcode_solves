class Solution {
    public int mod = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int ans = 0;
        Arrays.fill(dp, -1);
        for (int i = low; i <= high; i++) {
            ans = (ans + helper(i, zero, one, dp)) % mod;
            System.out.println(ans);
        }
        return ans;
    }

    public int helper(int n, int zero, int one, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) return dp[n];
        // System.out.println(dp[n]);
        return dp[n] = (helper(n - zero, zero, one, dp) + helper(n - one, zero, one, dp)) % mod;
    }
}
