class Solution {

    public int numTilings(int n) {
        if (n <= 3) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            if (n == 3) {
                return 5;
            }
        }

        int a1 = 1;
        int b1 = 2;
        int c1 = 5;
        int mod = 1000000007;

        for (int i = 3; i < n; i++) {
            int rest = (((2 * c1) % mod) + (a1 % mod)) % mod;
            a1 = b1;
            b1 = c1;
            c1 = rest;
        }

        return c1;
    }
}
