class Solution {
    List<Integer>[] adj;
    boolean[] visited;
    boolean[] marked;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            adj[i] = new ArrayList<>();
        }
        
        visited = new boolean[numCourses];
        marked = new boolean[numCourses];
        
        for(int i = 0 ; i < prerequisites.length ; i++){
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for(int i = 0 ; i < numCourses ; i++){
            if(!visited[i]){
                if(isCycle(i)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isCycle(int i){
        visited[i] = true;
        for(Integer j : adj[i]){
            if(!visited[j]){
                if(isCycle(j)){
                    return true;
                }
            }else if(!marked[j]){
                return true;
            }
        }
        marked[i] = true;
        return false;
    }
}