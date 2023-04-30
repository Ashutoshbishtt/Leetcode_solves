class Solution {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int en = edges.length;
        int usedEdges = 0;

        DSU dsu1 = new DSU(n + 1);
        DSU dsu2 = new DSU(n + 1);

        int type1Edges = 0;
        int type2Edges = 0;
        int type3Edges = 0;

        Arrays.sort(edges, (a, b) -> b[0] - a[0]);

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean v1 = dsu1.union(edge[1], edge[2]);
                boolean v2 = dsu2.union(edge[1], edge[2]);

                System.out.println(v1 + "  " + v2);
                if (v1 && v2) {
                    type3Edges++;
                }
            } else if (edge[0] == 1) {
                if (dsu1.union(edge[1], edge[2])) {
                    type1Edges++;
                }
            } else if (edge[0] == 2) {
                if (dsu2.union(edge[1], edge[2])) {
                    type2Edges++;
                }
            }
        }

        if ((type2Edges + type3Edges + 1 != n) || (type1Edges + type3Edges + 1 != n)) {
            return -1;
        } else {
            return en - type2Edges - type1Edges - type3Edges;
        }
    }
}

class DSU {
    private int[] rank;
    private int[] parent;

    public DSU(int n) {
        rank = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    public boolean union(int x, int y) {
        int xset = find(x), yset = find(y);

        if (xset == yset) return false;

        if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else {
            parent[yset] = xset;
        }

        if (rank[xset] == rank[yset]) rank[xset]++;

        return true;
    }
}
