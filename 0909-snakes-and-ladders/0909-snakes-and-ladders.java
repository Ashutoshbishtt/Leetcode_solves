class Solution {
    int res = -1, b[];

    public int snakesAndLadders(int[][] board) {
        int n = board.length, k = 1, steps = 0;
        b = new int[n * n + 1];
        int map[] = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = (i % 2 == 0) ? 0 : n - 1; j >= 0 && j < n;) {
                b[k++] = board[n - i - 1][j];
                if (i % 2 == 0) j++; else j--;
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        while (!stack.isEmpty()) {
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) {
                int curr = stack.pop();
                for (int i = curr + 1; i <= curr + 6; i++) {
                    int ind = (b[i] == -1) ? i : b[i];
                    if (map[ind] == 0) {
                        map[ind] = steps + 1;
                        if (ind == n * n) return map[ind];
                        temp.push(ind);
                    }
                }
            }
            stack = temp;
            steps++;
        }
        return -1;
    }
}
