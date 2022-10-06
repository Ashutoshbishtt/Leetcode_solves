class Solution {
    private long mod = 1000000007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp = new int[n+1];
        
        Arrays.fill(dp,-1);
        return (int) helper(1,delay,forget,n,dp);
    }
    
    private long helper(int i , int delay , int end , int target , int[] dp){
        if(i>target)return 0;
        
        long crt = 0l;
        
        for(int j = i+delay ; j <i+end ;j++){
            if(j<=target && dp[j]!=-1l)
                crt=crt+dp[j];
            else
                crt = crt + helper(j,delay,end,target,dp);
        }
        
        crt=crt%mod;
        
        if(i+end>target)crt+=1l;
        
        return dp[i]=(int)(crt%mod);
        
    }
}