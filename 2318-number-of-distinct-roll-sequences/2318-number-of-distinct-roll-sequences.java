class Solution {
    static int mod = 1000000007;
    
    public int distinctSequences(int n) {
        Long dp[][][] = new Long[n+1][7][7];
        
        return (int)(helper(1,0,0,n,dp)%mod);
    }
    
    static long helper(int i , int last , int secondlast , int n , Long dp[][][]){
        if(i>n){
            return 1;
        }
        
        if(dp[i][last][secondlast]!=null)return dp[i][last][secondlast];
        
        long ans = 0;
        for(int j = 1 ; j <= 6 ; j++){
            if(j==last || j ==secondlast || last!=0 && gcd(last,j)!=1){
                continue;
            }
            
            ans=(ans%mod+helper(i+1,j,last,n,dp)%mod)%mod;
        }
        return dp[i][last][secondlast]=ans;
    }
    
    static int gcd(int a , int b ){
        if(a==0)return b;
        return gcd(b%a,a);
    }
}