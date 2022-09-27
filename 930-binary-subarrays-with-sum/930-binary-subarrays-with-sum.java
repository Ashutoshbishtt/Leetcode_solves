class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int left = 0,right=0;
        int count = 0;
        int sum=0;
        
        for(;right<n;right++){
            sum+=nums[right];
            while(left<right && sum>goal){
                sum-=nums[left++];
            }
            if(sum==goal)count++;
            for(int i = left ; sum==goal && i<right && nums[i] == 0; i++){
                count++;
            }
        }
        return count;
    }
}