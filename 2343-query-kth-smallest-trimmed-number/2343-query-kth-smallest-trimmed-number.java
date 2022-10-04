class Solution {
    private class Pair{
        String s;
        int index;
        Pair(String s , int index){
            this.s = s;
            this.index = index;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Map<Integer,List<Pair>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            String str = nums[i];
            int n = str.length();
            int l = n;
            for(int j = 0 ; j < n ; j++){
                map.putIfAbsent(l,new ArrayList<>());
                Pair pair = new Pair(str.substring(j),i);
                map.get(l--).add(pair);
            }
        }
        
        int[] ans = new int[queries.length];
        int idx = 0;
        
        for(int[] query : queries){
            int kthE = query[0];
            int key = query[1];
            
            List<Pair> list = map.get(key);
            
            Collections.sort(list,(p1,p2)->{
                if(p1.s.equals(p2.s))
                return p1.index - p2.index;
                return p1.s.compareTo(p2.s);
                });
            ans[idx++] = list.get(kthE-1).index;
        }
        return ans;
    }
}