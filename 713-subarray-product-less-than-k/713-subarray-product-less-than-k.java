class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)return 0;
        
        int ans = 0;
        int prod = nums[0];
        if(prod<k)ans++;
        int left=0;
        int right=1;
        
        while(right!=nums.length){
            int val = nums[right];
            prod=prod*val;
            
            if(prod<k){
                ans+=right-left+1;
            }else{
                while(prod>=k){
                    prod/=nums[left++];
                }
                ans+=right-left+1;
            }
            right++;
        }
        return ans;
    }
}