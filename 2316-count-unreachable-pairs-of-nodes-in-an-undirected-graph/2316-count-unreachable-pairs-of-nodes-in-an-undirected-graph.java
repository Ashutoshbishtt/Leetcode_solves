class Solution {
    List<List<Integer>> adj = new ArrayList<>();

    public long countPairs(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        long res = 0, sum = n;

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int curr = dfs(i, vis, new int[1]);
                sum = sum - curr;
                res += curr * sum;
            }
        }
        return res;
    }

    int dfs(int node, boolean[] vis, int[] count) {
        if (vis[node]) return count[0];
        vis[node] = true;
        count[0]++;
        for (int curr : adj.get(node)) dfs(curr, vis, count);
        return count[0];
    }
}
