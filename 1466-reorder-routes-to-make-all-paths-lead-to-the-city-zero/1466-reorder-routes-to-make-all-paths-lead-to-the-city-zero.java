class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new LinkedList<>());
        }
        for (int [] c:connections) {
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(-c[0]);
        }
        boolean [] visited = new boolean[n];
        return dfs(adj, visited, 0);
    }
    public int dfs(List<List<Integer>>adj, boolean [] visited, int v) {
        int reOrderCount = 0;
        visited[v] = true;
        List<Integer> children = adj.get(v);
        for (Integer child: children) {
            if (!visited[Math.abs(child)])
                reOrderCount += dfs(adj, visited, Math.abs(child)) + (child > 0 ? 1:0);
        }
        return reOrderCount;
    }
}