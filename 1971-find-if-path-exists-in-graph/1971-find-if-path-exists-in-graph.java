class Solution {
    boolean found;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        found=false;
        if(source==destination)return true;
        
        Map<Integer,List<Integer>>graph = new HashMap();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList());
        }
        
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        dfs(graph,visited,source,destination);
        return found;
    }
    private void dfs(Map<Integer,List<Integer>>graph,boolean[] visited,int start,int end){
        if(visited[start] || found)return;
        
        visited[start]=true;
        
        for(int i : graph.get(start)){
            if(i==end){
                found=true;
                break;
            }
            if(!visited[i]){
                dfs(graph,visited,i,end);
            }
        }
    }
    
}