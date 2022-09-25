class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int lastBreak = -1;
        //记录上一个元素动态规划的结果
        int lastCount = 0;
        int res = 0;
        
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > right){
                lastBreak = i;
                lastCount = 0;
            }
            else if(nums[i] < left){
                res += lastCount;
            }
            else{
                lastCount = i - lastBreak;
                res += lastCount;
            }
        }
        
        return res;
    }
}