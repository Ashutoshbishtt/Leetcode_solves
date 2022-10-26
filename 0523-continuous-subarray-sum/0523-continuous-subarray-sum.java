class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        map.put(0,-1);
        
        int sum=0;
        for(int i = 0 ; i < nums.length ; i++){
            sum+=nums[i];
            int mod = k == 0 ? sum:sum%k;
            if(map.containsKey(mod) && i-map.get(mod)>1)return true;
            map.putIfAbsent(mod,i);
        }
        return false;
    }
}

// In this we have to calculate the mod of the sum store it in the hashmap, and if we find any mod value repeating than it means we have got the sum equal to K (this is the reason why wwe are getting the same reminder back) => than we will check the diff betweeen the occurence if it is greater that 1 than it is valid if it is not than return false; :) //