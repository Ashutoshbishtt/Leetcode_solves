class Solution {

    public int numSquares(int n) {
        int storage[] = new int[n + 1];
        storage[0] = 0;
        storage[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; (j * j) <= i; j++) {
                int temp = storage[i - (j * j)];

                if (temp < min) {
                    min = temp;
                }
            }

            storage[i] = 1 + min;
        }
        return storage[n];
    }
}
