class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int dp[][] = new int[n][26];
        
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,(char)(0),0,n,s,k,dp);
    }
    
    private int fun(int pick , char par , int ind , int n , String s , int k , int[][] dp){
        if(ind==n)return 0;
        if(pick==1 && dp[ind][par-'a']!=-1)return dp[ind][par-'a'];

        int notTake = fun(pick,par,ind+1,n,s,k,dp);
        int take = 0;
        if(pick==0 || Math.abs(par-s.charAt(ind))<=k){
            take = 1+fun(1,s.charAt(ind),ind+1,n,s,k,dp);
        }
        int temp = Math.max(notTake,take);
        if(pick==1)dp[ind][par-'a']=temp;
        return temp;
    }
}