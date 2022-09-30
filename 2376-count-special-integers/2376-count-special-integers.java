class Solution {
    static int[] f = new int[11];
    static {
        f[0] = f[1] = 1;
        for (int i = 2; i <= 10; ++i) f[i] = i * f[i - 1];
    }
    public int countSpecialNumbers(int n) {
        char[] cs = ("" + n).toCharArray();
        int m = cs.length, res = 0;
        for (int i = 1, j = 9, k = 9; i < m; ++i) {
            if (1 == i) res += 9;
            else {
                k *= j--;
                res += k;
            }
        }
        boolean valid = true;
        boolean[] seen = new boolean[10];
        for (int i = 0; i < m; ++i) {
            int hi = cs[i] - '0';       
            if (seen[hi]) valid = false;
            int cn = 9 - i, cm = m - i - 1, cnt = 0;
            for (int j = 0; j < hi; ++j) {
                if (0 == i && 0 == j) continue;
                if (!seen[j]) cnt++;
            }
            res += cnt * f[cn] / f[cn - cm];
            if (!valid) break;
            seen[hi] = true;              
        }
        if (valid) res++;
        return res;
    }
}