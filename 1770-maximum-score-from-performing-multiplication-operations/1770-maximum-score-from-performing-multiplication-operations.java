class Solution {
    private int n, m;
    private Integer[][] memo;


    public int maximumScore(int[] nums, int[] muls) {
        n = nums.length;
        m = muls.length;

        this.memo = new Integer[m][m];
        return dp(0, 0, nums, muls);
    }
    private int dp(int l, int i,int[] nums, int[] muls) {
        if (i == m) return 0;
        if (memo[l][i] != null) return memo[l][i];
        int pickLeft = dp(l+1, i+1, nums, muls) + nums[l] * muls[i];
        int pickRight = dp(l, i+1, nums, muls) + nums[n-(i-l)-1] * muls[i];
        return memo[l][i] = Math.max(pickLeft, pickRight);
    }
}