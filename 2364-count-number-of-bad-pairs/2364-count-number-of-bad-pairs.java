class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int diff = i-nums[i];
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        
        long total_pairs = (long)nums.length*(nums.length-1)/2;
        long goodPairs=0L;
        for(int key : map.keySet()){
            if(map.get(key)>1){
                long value = map.get(key);
                goodPairs+=value*(value-1)/2;
            }
        }
        return total_pairs-goodPairs;
    }
}