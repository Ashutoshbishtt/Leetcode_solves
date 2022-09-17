class Solution {
    private int mod = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        int dp[][] = new int[3002][1001];
        
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }
        
        return helper(startPos , endPos, startPos , k , dp);
    }
    private int helper(int s , int e , int c , int k , int[][] dp){
        if(k==0){
            if(c==e){
                return 1;
            }else{
                return 0;
            }
        }
        
        if(dp[c+1001][k]!=-1)return dp[c+1001][k];
        
        int left = helper(s,e,c-1,k-1,dp)%mod;
        int right = helper(s,e,c+1,k-1,dp)%mod;
        return dp[c+1001][k]=(left+right)%mod;
    }
}