class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        
        for(int i : restricted)vis[i]=true;
        
        for(int i = 0 ; i < n ; i++)adj.add(new ArrayList<Integer>());
        
        for(int it[] : edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        int count = 0;
        count+=dfs(adj,vis,0);
        
        return count;
    }
    
    private int dfs(ArrayList<ArrayList<Integer>> adj , boolean[] vis , int node){
        vis[node] = true;
        int c = 1;
        for(int it : adj.get(node)){
            if(vis[it]==false){
                c+=dfs(adj,vis,it);
            }
        }
        return c;
    }
}