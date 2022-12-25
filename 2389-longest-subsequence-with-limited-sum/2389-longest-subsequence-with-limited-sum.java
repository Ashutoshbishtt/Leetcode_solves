class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(ps[0],1);
        
        for(int i = 1 ; i < nums.length ; i++){
            ps[i]=ps[i-1]+nums[i];
            map.put(ps[i],i+1);
        }
        
        int[] ans = new int[queries.length];
        int i = 0;
        
        for(int query : queries){
            Map.Entry<Integer,Integer> entry = map.floorEntry(query);
            if(entry!=null){
                ans[i] = entry.getValue();
            }
            i++;
        }
        return ans;
    }
}

//Just have to sort the nums array,by doing this we will get the elements in sorted order and we can form the smallest sum till that point. And we have to save the sum at perticular index in TreeMap. And we can get the smallest value close to the queries[i]*//