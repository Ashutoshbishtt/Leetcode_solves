class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int nLen = nums.length;
        int shortest = nLen+1;
        
        long[] prefixSum = new long[nLen+1];
        for(int i = 0 ; i < nums.length ; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        
        Deque<Integer> startIdx = new ArrayDeque<>();
        
        for(int i = 0 ; i < nLen+1 ; i++){
            while(!startIdx.isEmpty() && prefixSum[i] - prefixSum[startIdx.peek()]>=k){
                shortest = Math.min(shortest,i-startIdx.poll());
            }
            while(!startIdx.isEmpty() && prefixSum[i] <= prefixSum[startIdx.peekLast()]){
                startIdx.pollLast();
            }
            
            startIdx.add(i);
            
        }
        return shortest <= nLen ? shortest : -1;
    }
}