class Solution {
    int longestCycleLength = -1;
    int[] nodeVisitedInCycle;
    int currCycle = 1;

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] timeNodeWasVisitedInCurrentTraversal = new int[n];
        nodeVisitedInCycle = new int[n];

        for (int node = 0; node < n; ++node) {
            traverseNode(edges, node, visited, timeNodeWasVisitedInCurrentTraversal, 1);
            ++currCycle;
        }

        return longestCycleLength;
    }

    public void traverseNode(int[] edges, int node, boolean[] visited, int[] timeNodeWasVisitedInCurrentTraversal, int currTime) {
        if (node == -1) {
            return;
        }

        if (visited[node]) {
            if (nodeVisitedInCycle[node] != currCycle) {
                return;
            } else {
                int visitedTime = timeNodeWasVisitedInCurrentTraversal[node];
                longestCycleLength = Math.max(longestCycleLength, currTime - visitedTime);
                return;
            }
        }

        visited[node] = true;
        nodeVisitedInCycle[node] = currCycle;
        timeNodeWasVisitedInCurrentTraversal[node] = currTime;

        traverseNode(edges, edges[node], visited, timeNodeWasVisitedInCurrentTraversal, currTime + 1);
    }
}
