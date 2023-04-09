class Solution {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        char[] colorArray = colors.toCharArray();
        int[] indegree = new int[n];

        List<List<Integer>> adj = new ArrayList<>();
        IntStream.range(0, n).forEach(a -> adj.add(new ArrayList<>()));
        for (int[] edge : edges) {
            indegree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
        }

        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int[][] opt = new int[n][26];
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                deque.offer(i);
                opt[i][colorArray[i] - 'a'] = 1;
                res = 1;
            }
        }

        while (!deque.isEmpty()) {
            int cur = deque.pop();
            for (int i : adj.get(cur)) {
                int c = colorArray[i] - 'a';
                for (int j = 0; j < 26; j++) {
                    if (j == c) {
                        opt[i][c] = Math.max(opt[i][c], opt[cur][c] + 1);
                        res = Math.max(res, opt[i][j]);
                    } else {
                        opt[i][j] = Math.max(opt[i][j], opt[cur][j]);
                        res = Math.max(res, opt[i][j]);
                    }
                }
                indegree[i]--;
                if (indegree[i] == 0) {
                    deque.offer(i);
                }
            }
        }
        for (int v : indegree) {
            if (v != 0) return -1;
        }
        return res;
    }
}
