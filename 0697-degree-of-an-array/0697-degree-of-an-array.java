class Solution {
    public int findShortestSubArray(int[] nums) {
       HashMap<Integer,Integer> freqMap = new HashMap<>();
        HashMap<Integer,Integer> seenMap = new HashMap<>();
        int degree=0;
        int minLength=0;
        for(int i=0;i<nums.length;i++){
            seenMap.putIfAbsent(nums[i],i);// this will store the index of first seen occurence
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
            if(degree<freqMap.get(nums[i])){
                degree=freqMap.get(nums[i]);
                minLength= i-seenMap.get(nums[i])+1;
            }
            else if(degree==freqMap.get(nums[i])){
                minLength= Math.min(minLength,i-seenMap.get(nums[i])+1);
            }
        }
        return minLength;
    }
}