class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int end = nums.length-1;
        
        while(mid<=end){
            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }else if(nums[mid]==2){
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            }else{
                mid++;
            }
        }
    }
}