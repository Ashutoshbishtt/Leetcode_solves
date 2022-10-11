class Solution {

    public boolean wordBreak(String st, List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : list) map.put(s, 1);

        int dp[] = new int[st.length()];
        Arrays.fill(dp, -1);

        return solverec(st, map, 0, dp) == 1 ? true : false;
    }

    private int solverec(String str, HashMap<String, Integer> map, int i, int dp[]) {
        if (i == str.length()) return 1;

        if (dp[i] != -1) return dp[i];

        String s = "";

        for (int j = i; j < str.length(); j++) {
            s += str.charAt(j);
            if (map.containsKey(s) && solverec(str, map, j + 1, dp) == 1) {
                return dp[i] = 1;
            }
        }
        return dp[i] = 0;
    }
}
