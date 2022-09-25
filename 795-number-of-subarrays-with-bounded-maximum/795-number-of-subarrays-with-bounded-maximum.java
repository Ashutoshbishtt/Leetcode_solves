class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int smaller=0;
        
        while(i!=nums.length){
            if(nums[i]>=left && nums[i]<=right){
                smaller=i-j+1;
                ans+=smaller;
            }else if(nums[i]<left){
                ans+=smaller;
            }else{
                j=i+1;
                smaller=0;
            }
            i++;
        }
        return ans;
    }
}