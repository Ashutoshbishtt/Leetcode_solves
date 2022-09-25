//We just need to find the cycle in the graph. if any node is a part of cycle or creates cycle we will just not add that node in the ans


enum State{
    VISITING,
    VISITED
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> output = new ArrayList<>();
        if(graph==null || graph.length==0){
            return output;
        }
        
        int n = graph.length;
        State[] states = new State[n];
        
        for(int node = 0 ; node<n ; node++){
            if(!hasCycleDFS(node,graph,states)){
                output.add(node);
            }
        }
        return output;
    }
    
    private boolean hasCycleDFS(int node,int[][] graph, State[] states){
        if(states[node]!=null){
            return states[node] == State.VISITING;
        }
        
        states[node] = State.VISITING;
        
        for(int next : graph[node]){
            if(hasCycleDFS(next,graph,states)){
                return true;
            }
        }
        
        states[node] = State.VISITED;
        return false;
    }   
}