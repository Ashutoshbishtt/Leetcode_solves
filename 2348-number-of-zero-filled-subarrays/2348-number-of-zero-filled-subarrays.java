class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int j = -1;
        
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]!=0)j=i;
            else{
                ans+=i-j;
            }
        }
        return ans;
    }
}