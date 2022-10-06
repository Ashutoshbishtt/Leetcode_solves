class NumberContainers {
    Map<Integer,TreeSet<Integer>> map;
    Map<Integer,Integer> m;
    public NumberContainers() {
        map = new HashMap<>();
        m = new HashMap<>();
    }
    
    public void change(int index, int number) {
        m.put(index,number);
        if(!map.containsKey(number)) map.put(number,new TreeSet<>());
        map.get(number).add(index);
    }
    
    public int find(int number) {
        if(!map.containsKey(number))return -1;
        for(Integer a : map.get(number)){
            if(m.get(a)==number)return a;
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */