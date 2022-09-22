class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1 ; i < nums.length ; i++){
            set.add(nums[i]+nums[i-1]);
        }
        
        if(set.size()==nums.length-1)return false;
        return true;   
    }
}