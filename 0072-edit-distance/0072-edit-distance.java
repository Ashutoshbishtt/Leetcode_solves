class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int storage[][] = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= m; i++) {
            storage[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            storage[0][i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    storage[i + 1][j + 1] = storage[i][j];
                } else {
                    int a = storage[i][j];
                    int b = storage[i][j + 1];
                    int c = storage[i + 1][j];
                    storage[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);

                    storage[i + 1][j + 1]++;
                }
            }
        }
        return storage[m][n];
    }
}
