class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int l = 0;
        int res = 1, max = 0, min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
            if(max-min<=limit) {res=Math.max(res,i-l+1); continue;}
            l = i;
            min = max = nums[i];
            while(l>0&&Math.abs(nums[l-1]-nums[i])<=limit){
                l--;
                max = Math.max(max,nums[l]);
                min = Math.min(min,nums[l]);
            }
        }
        return res;
    }
}