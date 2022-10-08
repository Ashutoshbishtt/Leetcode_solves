class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m+1][n+1];
        
        for(int[] price : prices){
            int x = price[0];
            int y = price[1];
            int sellingCost = price[2];
            dp[x][y] = sellingCost;
        }
        
        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n; j ++){
                for(int k = 0 ; k <= i ; k ++){
                    dp[i][j] = Math.max(dp[i][j],dp[i-k][j]+dp[k][j]);
                }
                
                for(int k = 0 ; k<= j ; k++){
                    dp[i][j] = Math.max(dp[i][j],dp[i][j-k]+dp[i][k]);
                }
            }
        }
        return dp[m][n];
    }
}