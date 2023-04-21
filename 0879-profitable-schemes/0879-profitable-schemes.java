class Solution {
    int groups[];
    int profits[];
    Integer dp[][][];
    final int MOD = (int) (1e9 + 7);

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new Integer[101][101][101];

        groups = group;
        profits = profit;

        return getNumSchemas(n, minProfit, 0, 0, 0);
    }

    private int getNumSchemas(int n, int minProfit, int curIdx, int curProfit, int curThiefs) {
        if (curIdx == groups.length) {
            return curProfit >= minProfit ? 1 : 0;
        }

        if (dp[curIdx][curProfit][curThiefs] != null) {
            return dp[curIdx][curProfit][curThiefs];
        }

        int leave = getNumSchemas(n, minProfit, curIdx + 1, curProfit, curThiefs);
        int take = 0;

        if (curThiefs + groups[curIdx] <= n) {
            take = getNumSchemas(n, minProfit, curIdx + 1, Math.min(minProfit, curProfit + profits[curIdx]), curThiefs + groups[curIdx]);
        }

        return dp[curIdx][curProfit][curThiefs] = (leave + take) % MOD;
    }
}
