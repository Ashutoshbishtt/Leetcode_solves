class Solution {

    public int shortestPath(int[][] grid, int k) {
        int step = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] DIRS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int[][] seen = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, 0 });
        seen[0][0] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return step;
                }
                for (int[] dir : DIRS) {
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    int o = grid[x][y] + cur[2];
                    if (o >= seen[x][y] || o > k) {
                        continue;
                    }
                    seen[x][y] = o;
                    q.offer(new int[] { x, y, o });
                }
            }
            ++step;
        }
        return -1;
    }
}
