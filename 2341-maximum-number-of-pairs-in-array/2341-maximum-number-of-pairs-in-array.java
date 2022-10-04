class Solution {
    public int[] numberOfPairs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                set.remove(nums[i]);
                count++;
            }
        }
        return new int[]{count,set.size()};
    }
    
}