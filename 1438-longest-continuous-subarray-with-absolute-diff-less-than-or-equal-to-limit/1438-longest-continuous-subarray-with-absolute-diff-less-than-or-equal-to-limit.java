class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int start = 0;
        int end = 0;
        int res = 1;
        
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        while(start<=end && end<nums.length){
            minQ.offer(nums[end]);
            maxQ.offer(nums[end]);
            
            int minNum = minQ.peek();
            int maxNum = maxQ.peek();
            
            if(maxNum - minNum <= limit){
                end++;
                res=Math.max(res,end-start);
            }else{
                minQ.remove(nums[start]);
                maxQ.remove(nums[start]);
                start++;
                end++;
            }
        }
        return res;
    }
}