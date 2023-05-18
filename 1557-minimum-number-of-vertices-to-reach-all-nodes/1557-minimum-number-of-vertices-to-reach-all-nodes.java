class Solution {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] indegree = new boolean[n];
        for (int i = 0; i < edges.size(); i++) {
            indegree[edges.get(i).get(1)] = true;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!indegree[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
