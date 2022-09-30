class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }
        int count = 0;
        for(int it: nums){
            if(set.contains(it+diff) && set.contains(it+diff*2))count++;
        }
        return count;
    }
}