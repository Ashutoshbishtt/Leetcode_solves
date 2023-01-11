class Solution {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int l = 0;
        for (int i = 0; i < hasApple.size(); i++) {
            if (hasApple.get(i) == false) l++; else break;
        }
        if (l == hasApple.size()) return 0;
        ArrayList<ArrayList<Integer>> adjList = buildAjList(edges);
        boolean[] vis = new boolean[n];
        return dfs(0, adjList, hasApple, vis);
    }

    public int dfs(int node, ArrayList<ArrayList<Integer>> adjList, List<Boolean> hasApple, boolean[] vis) {
        int c = 0;
        vis[node] = true;
        for (Integer it : adjList.get(node)) {
            if (vis[it] == false) {
                c += dfs(it, adjList, hasApple, vis);
            }
        }
        if ((c > 0 || hasApple.get(node)) && node != 0) c += 2;
        return c;
    }

    public ArrayList<ArrayList<Integer>> buildAjList(int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= edges.length; i++) adjList.add(new ArrayList<Integer>());

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        return adjList;
    }
}
