class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(Integer i : tasks){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        int res = 0;
        
        for(int value : map.values()){
            if(value==1)return -1;
            res+=(value+2)/3;
        }
        return res;
    }
}