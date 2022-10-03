class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int it : nums)if(it!=0)set.add(it);
        return set.size();
    }
}