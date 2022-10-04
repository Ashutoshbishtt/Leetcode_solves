class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int res = 0;
        Map<String , Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < n ; j++){
                sb.append(grid[i][j]);
                sb.append("+");
            }
            String s = sb.toString();
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        for(int j = 0 ; j < n ; j++){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < n ; i++){
                sb.append(grid[i][j]);
                sb.append("+");
            }
            
            String s = sb.toString();
            if(map.containsKey(s)){
                res+=map.get(s);
            }
        }
        return res;
    }
}