class Solution {
    public long kSum(int[] nums, int k) {
        PriorityQueue<Long> ans = new PriorityQueue<>((v1,v2)->Long.compare(v1,v2));
        PriorityQueue<Integer> heap = new PriorityQueue<>((v1,v2)->Long.compare(v2,v1));
        long sum = 0;
        for(int num : nums){
            if(num>0){
                sum+=num;
                num=-num;
            }
            heap.offer(num);
        }
        ans.offer(sum);
        while(!heap.isEmpty()){
            int next = heap.poll();
            boolean canAdd = false;
            List<Long> list = new ArrayList<>();
            for(long val : ans){
                list.add(val+next);
            }
            for(long val : list){
                if(ans.size() < k){
                    ans.offer(val);
                    canAdd = true;
                }else if(val>ans.peek()){
                    ans.offer(val);
                    canAdd = true;
                    ans.poll();
                }
            }
            if(!canAdd){
                break;
            }
        }
        return ans.poll();
    }
}