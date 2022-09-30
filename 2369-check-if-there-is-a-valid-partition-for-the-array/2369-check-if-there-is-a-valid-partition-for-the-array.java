class Solution {
    Boolean[] dp;
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        dp = new Boolean[n];
        return helper(nums,0,n);
    }
    
    private boolean helper(int[] arr , int idx , int n){
        if(idx==n)return true;
        
        if(dp[idx]!=null)return dp[idx];
        
        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;
        
        if(idx+1<n){
            if(arr[idx]==arr[idx+1]){
                f1 = helper(arr,idx+2,n);
            }
        }
        if(idx+2<n){
            if(arr[idx]==arr[idx+1] && arr[idx+1] ==arr[idx+2]){
                f2 = helper(arr,idx+3,n);
            }
            if(arr[idx+2] - arr[idx+1] == 1 && arr[idx+1]-arr[idx]==1){
            f3=helper(arr,idx+3,n);
            }
        }
        
        return dp[idx] = f1 || f2 || f3;
    }
}