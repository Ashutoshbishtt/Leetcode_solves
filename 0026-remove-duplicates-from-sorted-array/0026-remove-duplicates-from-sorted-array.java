class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int prev = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]!=nums[prev]){
                nums[count++]=nums[i];
                prev++;
            }
        }
        return count;
    }
}