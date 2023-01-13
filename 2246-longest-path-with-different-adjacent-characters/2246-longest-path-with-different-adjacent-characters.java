class Solution {

    public int longestPath(int[] parent, String s) {
        int max = 1;
        int dp[] = new int[parent.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean visited[] = new boolean[parent.length];
        for (int i = parent.length - 1; i >= 0; i--) {
            if (i != 0) {
                int par = parent[i];
                map.putIfAbsent(par, new ArrayList<>());
                map.get(par).add(i);
            }
            if (visited[i] == true) continue;
            visited[i] = true;
            char prev = s.charAt(i);
            int path = 1;
            dp[i] = Math.max(dp[i], path);
            int curr = parent[i];
            while (curr != -1 && prev != s.charAt(curr)) {
                visited[curr] = true;
                prev = s.charAt(curr);
                path++;
                dp[curr] = Math.max(dp[curr], path);
                curr = parent[curr];

                max = Math.max(max, path);
            }
            max = Math.max(max, path);
        }

        for (int par : map.keySet()) {
            List<Integer> children = map.get(par);
            if (children.size() == 1) continue;
            boolean flag = true;
            for (int e : children) {
                if (dp[e] + 1 == dp[par] && flag == true && s.charAt(e) != s.charAt(par)) {
                    flag = false;
                } else {
                    if (s.charAt(e) != s.charAt(par)) {
                        max = Math.max(max, dp[e] + dp[par]);
                    }
                }
            }
        }
        return max;
    }
}
