class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        if(n==0 && target==0)return 1;
        
        int[][] dp = new int[n+1][target+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=target;j++){
                dp[i][j]=-1;
            }
        }
        
        return numRollsHelper(n,k,target,dp,(int) Math.pow(10, 9) + 7);
        
    }
    
    private  int numRollsHelper(int n , int k , int target,int[][]dp,int mod){
        if(n==0 && target==0)return 1;
        if(n<=0 || target<=0)return 0;
        
        if(dp[n][target]!=-1)return dp[n][target];
        
        int count=0;
        
        for(int i=1;i<=k;i++){
            count=(count+numRollsHelper(n-1,k,target-i,dp,mod))% mod;
        }
        return dp[n][target]=count;
    }
}