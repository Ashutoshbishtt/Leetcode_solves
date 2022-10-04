class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            int bitCounts = Integer.bitCount(nums[i]);
            if(!set.contains(nums[i])&&map.containsKey(bitCounts)){
                set.add(nums[i]);
                map.put(bitCounts, map.get(bitCounts)+1);
            }
            else{
                if(!set.contains(nums[i])){
                    map.put(bitCounts, 1);
                    set.add(nums[i]);
                }
            }
        }
        long ans = 0;
        for(int i: map.keySet()){
            for(int j : map.keySet()){
                if(i+j>=k){
                    ans+=map.get(i)*map.get(j);
                }
            }
        }
        return ans;
    }
}