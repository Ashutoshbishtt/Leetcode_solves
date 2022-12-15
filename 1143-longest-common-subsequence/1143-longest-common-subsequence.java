class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int x = s1.length();
        int y = s2.length();
        
        int[][] dp = new int[x][y];
        
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                dp[i][j]=-1;
            }
        }
        return lcsHelper(x-1,y-1,s1,s2,dp);
    }
    
    static int lcsHelper(int x , int y , String s1 , String s2 , int dp[][]){
        
        if(x<0 || y<0)return 0;
        
        if(dp[x][y]!=-1)return dp[x][y];
        
        if(s1.charAt(x)==s2.charAt(y))return 1+lcsHelper(x-1,y-1,s1,s2,dp);
        
        int one = lcsHelper(x-1,y,s1,s2,dp);
        int two = lcsHelper(x,y-1,s1,s2,dp);
        return dp[x][y] = Math.max(one,two);
    }
    
}