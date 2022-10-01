class LUPrefix {
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    int n;
    int count=0;
    public LUPrefix(int n) {
        this.n=n;
    }
    
    public void upload(int video) {
        pq.add(video);
        while(!pq.isEmpty() && pq.peek()-count==1){
            count++;
            pq.remove();
        }
    }
    
    public int longest() {
        return count;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */