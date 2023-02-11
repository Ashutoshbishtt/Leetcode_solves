class Solution {

    private int[] bfs(int n, Map<Integer, Set<Integer>> red, Map<Integer, Set<Integer>> blue) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }
        boolean[] redVisited, blueVisited;
        redVisited = new boolean[n];
        blueVisited = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        int node = 0;
        int distance = 0;
        int color = -1; // -1 : No color, 0 : red, 1 : blue
        int[] arr = new int[] { node, distance, color };
        q.add(arr);
        redVisited[0] = blueVisited[0] = true;
        while (!q.isEmpty()) {
            arr = q.poll();
            node = arr[0];
            distance = arr[1];
            color = arr[2];
            if (ans[node] == -1 || distance < ans[node]) {
                ans[node] = distance;
            }
            distance++;
            if (color != 0) {
                for (int neighbour : red.getOrDefault(node, new HashSet<>())) {
                    if (!redVisited[neighbour]) {
                        redVisited[neighbour] = true;
                        q.add(new int[] { neighbour, distance, 0 });
                    }
                }
            }
            if (color != 1) {
                for (int neighbour : blue.getOrDefault(node, new HashSet<>())) {
                    if (!blueVisited[neighbour]) {
                        blueVisited[neighbour] = true;
                        q.add(new int[] { neighbour, distance, 1 });
                    }
                }
            }
        }
        return ans;
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, Set<Integer>> red, blue;
        red = new HashMap<>();
        blue = new HashMap<>();
        for (int[] redEdge : redEdges) {
            red.computeIfAbsent(redEdge[0], s -> new HashSet<>()).add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            blue.computeIfAbsent(blueEdge[0], s -> new HashSet<>()).add(blueEdge[1]);
        }
        return bfs(n, red, blue);
    }
}
