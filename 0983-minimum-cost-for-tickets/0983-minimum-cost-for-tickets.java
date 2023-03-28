class Solution {
    int len;
    int[] days;
    int[] costs;
    int[] pass;
    int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        this.len = days.length;
        this.days = days;
        this.costs = costs;
        pass = new int[] { 1, 7, 30 };
        dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return dfs(0);
    }

    int dfs(int idx) {
        if (idx == len) return 0;
        if (dp[idx] != Integer.MAX_VALUE) return dp[idx];
        for (int i = 0; i < 3; i++) {
            int j = idx;
            while (j < len && days[j] < days[idx] + pass[i]) j++;
            dp[idx] = Math.min(dp[idx], costs[i] + dfs(j));
        }
        return dp[idx];
    }
}
