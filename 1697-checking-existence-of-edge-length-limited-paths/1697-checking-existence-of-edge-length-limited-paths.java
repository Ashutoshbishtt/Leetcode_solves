class Solution {
    int[] parents, rank;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        parents = new int[n];
        rank = new int[n];
        for (int i = 0; i < parents.length; i++) parents[i] = i;
        boolean[] resp = new boolean[queries.length];
        Helper[] q = new Helper[queries.length];
        for (int i = 0; i < q.length; i++) q[i] = new Helper(queries[i], i);
        Arrays.sort(q, (a, b) -> a.query[2] - b.query[2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int a = 0, b = 0;
        while (a < edgeList.length || b < q.length) {
            if (b == q.length) break;
            Helper next = q[b];
            while (a < edgeList.length && edgeList[a][2] < next.query[2]) uf(edgeList[a][0], edgeList[a++][1]);
            if (parent(next.query[0]) == parent(next.query[1])) resp[next.index] = true;
            b++;
        }
        return resp;
    }

    boolean uf(int a, int b) {
        int pa = parent(a), pb = parent(b);
        if (pa == pb) return false;
        if (rank[pa] > rank[pb]) {
            rank[pa] += rank[pb] + 1;
            parents[pb] = pa;
        } else {
            rank[pb] += rank[pa] + 1;
            parents[pa] = pb;
        }
        return true;
    }

    int parent(int a) {
        int pa = parents[a];
        if (a != pa) parents[a] = pa = parent(pa);
        return pa;
    }

    class Helper {
        int[] query;
        int index;

        Helper(int[] query, int index) {
            this.query = query;
            this.index = index;
        }
    }
}
