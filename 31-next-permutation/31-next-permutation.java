class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length == 1)return;
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])i--;
        if(i>=0){
            int j = nums.length-1;
            while(nums[j]<=nums[i])j--;
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
            reverse(nums,i+1,nums.length-1);
    }
    private void reverse(int[] nums , int start , int end ){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }
}