class Solution {
    int dp[][];

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1 + 1; i++) for (int j = 0; j < n2 + 1; j++) dp[i][j] = -1;
        return fun(0, 0, nums1, nums2);
    }

    public int fun(int i, int j, int nums1[], int nums2[]) {
        if (i == nums1.length || j == nums2.length) return dp[i][j] = 0;
        if (dp[i][j] != -1) return dp[i][j];
        int p1 = Math.max(fun(i + 1, j, nums1, nums2), fun(i, j + 1, nums1, nums2));
        int p2 = 0;
        if (nums1[i] == nums2[j]) {
            p2 = 1 + fun(i + 1, j + 1, nums1, nums2);
        }
        return dp[i][j] = Math.max(p1, p2);
    }
}
