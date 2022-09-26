class Solution {
    class Pair{
        int row;
        int col;
        Integer val;
        
        Pair(int row , int col , Integer val ){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        
        int max = 0;
        
        for(int i = 0 ; i < nums.size() ; i++){
            max = Math.max(max,nums.get(i).get(0));
            pq.add(new Pair(i,0,nums.get(i).get(0)));
        }
        
        int[] ans = new int[2];
        
        int range = Integer.MAX_VALUE;
        while(pq.size()>0){
            Pair p = pq.remove();
            
            if(max-p.val<range){
                ans[0] = p.val;
                ans[1] = max;
                range = max - p.val;
            }
            
            if(p.col+1 < nums.get(p.row).size()){
                max = Math.max(nums.get(p.row).get(p.col+1),max);
                pq.add(new Pair(p.row , p.col+1 , nums.get(p.row).get(p.col+1)));
            }
            else break;
        }
        return ans;
    }
}