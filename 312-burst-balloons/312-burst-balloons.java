class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i=1;i<=n;i++){
            arr[i] = nums[i-1];
        }
        
        int memo[][] = new int[n+2][n+2];
        return burst(memo, arr, 0, n + 1);
        
    }
    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        
        if (memo[left][right] > 0) return memo[left][right];
        
        int ans = 0;
        
        for (int i = left + 1; i < right; ++i){
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
            + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        }
        memo[left][right] = ans;
        
        return ans;
    }
    
}