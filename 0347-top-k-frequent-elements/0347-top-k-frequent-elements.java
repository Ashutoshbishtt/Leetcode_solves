class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);    
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2)
        );
        
        for(int n : count.keySet()) {
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }
        
        int[] ans = new int[k];
        for(int i = k-1; i >= 0; i--) {
            ans[i] = heap.poll();
        }
        
        return ans;
    }
}