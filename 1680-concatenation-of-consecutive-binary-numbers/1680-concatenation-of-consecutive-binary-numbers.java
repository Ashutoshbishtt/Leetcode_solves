class Solution {
    public int concatenatedBinary(int n) {
        long mod = (long) (1e9+7);
        long result = 0;
        
        for(int i = 0 ; i <=n ; i++){
            int temp = i;
            while(temp>0){
                temp/=2;
                result*=2;
            }
            result=(result+i)%mod;
        }
        return (int)result;
    }
}