class Solution {

    public boolean isScramble(String s1, String s2) {
        dp = new HashMap<>();
        return util(s1, s2);
    }

    private Map<String, Boolean> dp;

    private boolean util(String s, String t) {
        if (s.equals(t)) return true;

        String key = s + t;
        if (dp.containsKey(key)) return dp.get(key);

        int n = s.length();
        for (int d = 1; d < n; d++) {
            String x = s.substring(0, d);
            String y = s.substring(d);

            boolean ret = (util(x, t.substring(0, x.length())) && util(y, t.substring(x.length()))) || (util(y, t.substring(0, y.length())) && util(x, t.substring(y.length())));
            if (ret) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }
}
