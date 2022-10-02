class Solution {
    public int longestIdealString(String s, int k) {
        int[][] dp = new int[s.length()][27];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 27; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(s, 0, k, 26, dp);
    }
    public int dfs(String s, int currentPosition, int k, int previousChar, int[][] dp) {
        if (currentPosition >= s.length()) {
            return 0;
        }
        if (dp[currentPosition][previousChar] != -1) {
            return dp[currentPosition][previousChar];
        }
        int currentChar = s.charAt(currentPosition) - 'a';
        int result = dfs(s, currentPosition + 1, k, previousChar, dp);
        if (previousChar == 26 || Math.abs(currentChar - previousChar) <= k) {
            result = Math.max(result, 1 + dfs(s, currentPosition + 1, k, currentChar, dp));
        }
        dp[currentPosition][previousChar] = result;
        return result;
    }
}