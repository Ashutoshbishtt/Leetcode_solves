class Solution {
    ArrayList<Integer> graph[];

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        char c[][] = new char[n][];
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            c[i] = strs[i].toCharArray();
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(c[i], c[j])) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        int ans = 0;
        boolean v[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                ans++;
                dfs(i, v);
            }
        }
        return ans;
    }

    public void dfs(int s, boolean v[]) {
        v[s] = true;
        for (int i : graph[s]) {
            if (!v[i]) {
                dfs(i, v);
            }
        }
    }

    public boolean check(char c1[], char c2[]) {
        int ind1 = -1, ind2 = -1;
        int n = c1.length;
        if (n == 1) {
            return c1[0] == c2[0];
        }
        int q = 0;
        for (int i = 0; i < n; i++) {
            if (c1[i] != c2[i]) {
                if (ind1 == -1) {
                    ind1 = i;
                } else if (ind2 == -1) {
                    ind2 = i;
                } else {
                    q = 1;
                    break;
                }
            }
        }
        if (q == 1) return false;
        if (ind2 == -1 && ind1 == -1) return true;
        if (ind1 == -1 || ind2 == -1) return false;
        if (c1[ind1] == c2[ind2] && c1[ind2] == c2[ind1]) return true;
        return false;
    }
}
