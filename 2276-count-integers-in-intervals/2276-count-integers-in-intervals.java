class CountIntervals {
    
    TreeMap<Integer,Integer> tm;
    int cnt = 0;
    
    public CountIntervals() {
        tm = new TreeMap<>();
    }
    
    public void add(int left, int right) {
        int l = left;
        int r = right;
        
        while(!(tm.floorKey(r)==null || tm.get(tm.floorKey(r))<l)){
            int preL = tm.floorKey(r);
            int preR = tm.get(preL);
            cnt-=(preR-preL+1);
            tm.remove(preL);
            l=Math.min(l,preL);
            r=Math.max(r,preR);
        }
        tm.put(l,r);
        cnt+=(r-l+1);
    }
    
    public int count() {
        return cnt;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */