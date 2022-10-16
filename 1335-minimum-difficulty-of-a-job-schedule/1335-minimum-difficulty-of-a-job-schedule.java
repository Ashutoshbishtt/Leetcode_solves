class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d)return -1;
        
        int dp[][] = new int[d+1][jobDifficulty.length];
        for(int[] p : dp){
            Arrays.fill(p,-1);
        }
        return dfs(jobDifficulty,dp,d,0);
    }
    
    private int dfs(int[] jobDifficulty , int[][] dp , int d , int indx){
        if(d==1){
            int max = 0;
            while(indx<jobDifficulty.length){
                max = Math.max(max,jobDifficulty[indx++]);
            }
            return max;
        }
        
        if(dp[d][indx]!=-1){
            return dp[d][indx];
        }
        
        int leftMax=0;
        
        int res = Integer.MAX_VALUE;
        for(int i = indx ; i < jobDifficulty.length-d+1 ; i++){
            leftMax = Math.max(leftMax,jobDifficulty[i]);
            int rightMax = dfs(jobDifficulty,dp,d-1,i+1);
            res = Math.min(res,leftMax+rightMax);
        }
        return dp[d][indx] = res;
    }
}