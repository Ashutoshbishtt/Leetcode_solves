class Node {
    int source;
    int destination;
    int distance;

    Node(int s, int d, int dd) {
        source = s;
        destination = d;
        distance = dd;
    }
}

class Solution {

    public int func(int n, List<Node> arr[], int vis[]) {
        int ans = Integer.MAX_VALUE;
        Queue<List<Node>> qs = new LinkedList();

        qs.offer(arr[1]);

        while (!qs.isEmpty()) {
            List<Node> li = qs.poll();
            if (li == null || li.size() == 0) {
                continue;
            }
            Node x = li.get(0);
            if (vis[x.source] == 1) {
                continue;
            }
            vis[x.source] = 1;
            for (int i = 0; i < li.size(); i++) {
                Node adjancent = li.get(i);
                int distance = adjancent.distance;
                ans = Math.min(ans, distance);
                qs.offer(arr[adjancent.destination]);
            }
        }
        return ans;
    }

    public int minScore(int n, int[][] roads) {
        List<Node> li[] = new ArrayList[n + 1];

        for (int arr[] : roads) {
            Node temp = new Node(arr[0], arr[1], arr[2]);
            Node temp1 = new Node(arr[1], arr[0], arr[2]);
            if (li[arr[0]] == null) {
                li[arr[0]] = new ArrayList();
            }
            if (li[arr[1]] == null) {
                li[arr[1]] = new ArrayList();
            }

            li[arr[0]].add(temp);
            li[arr[1]].add(temp1);
        }
        int vis[] = new int[n + 1];
        return func(n, li, vis);
    }
}
