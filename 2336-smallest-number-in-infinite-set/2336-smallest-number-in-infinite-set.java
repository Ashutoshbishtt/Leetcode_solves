class SmallestInfiniteSet {
    PriorityQueue<Integer> pq = null;
    int current = 0;
    
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        current = 1;
    }
    
    public int popSmallest() {
        int result = current;
        if(!pq.isEmpty() && pq.peek()<current){
            result = pq.poll();
        }else{
            current++;
        }
        
        while(!pq.isEmpty() && pq.peek()==result)pq.poll();
        
        return result;
        
    }
    
    public void addBack(int num) {
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */