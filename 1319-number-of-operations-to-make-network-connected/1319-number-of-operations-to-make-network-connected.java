class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
            adj.add(new ArrayList<>());
        for(int[] edge : connections){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        int count = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                count++;
                dfs(adj,i,visited);
            }
        }
        
        return count-1;
    }
    
    void dfs(ArrayList<ArrayList<Integer>>adj , int node , boolean[] visited){        
        visited[node] = true;
        for(int i : adj.get(node)){
            if(!visited[i])
                dfs(adj,i,visited);
        }
    }
    
}