class Solution {

    private boolean isValidNeighb(int neighb, int n, boolean[] visited) {
        if (neighb >= 0 && neighb < n && !visited[neighb]) {
            return true;
        }

        return false;
    }

    private void populateFreqMap(Map<Integer, List<Integer>> freqMap, int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int value = arr[i];
            freqMap.putIfAbsent(value, new ArrayList<>());
            freqMap.get(value).add(i);
        }
    }

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> freqMap = new HashMap<>();
        int n = arr.length;
        populateFreqMap(freqMap, arr, n);

        Queue<Integer> bfs = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int distance = 0, destination = n - 1;
        bfs.add(0);
        while (bfs.size() > 0) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                int front = bfs.poll();
                visited[front] = true;

                if (front == destination) {
                    return distance;
                }

                int value = arr[front];
                List<Integer> neighbList = freqMap.get(value);
                neighbList.add(front - 1);
                neighbList.add(front + 1);

                for (Integer neighb : neighbList) {
                    if (isValidNeighb(neighb, n, visited)) {
                        bfs.add(neighb);
                    }
                }

                neighbList.clear();
            }

            distance++;
        }

        return -1;
    }
}
