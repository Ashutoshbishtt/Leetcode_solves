class Solution {

    public int getLengthOfOptimalCompression(String s, int k) {
        int N = s.length();
        int[][] dp = new int[N+1][k+1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], N);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int kk = 0; kk <= Math.min(i, k); kk++) {
                if (kk-1 >= 0) {
                    dp[i][kk] = dp[i-1][kk-1]; 
                }
                

                char cur = s.charAt(i-1);

                int maxDel = kk; 
                int curCharCount = 0;
                for (int j = i-1; j >= 0; j--) {
                    if (s.charAt(j) == cur) {
                        curCharCount++;
                    } else {
                        maxDel--;
                    }

                    if (maxDel < 0) {
                        break;
                    }

                    dp[i][kk] = Math.min(dp[i][kk], dp[j][maxDel] + getLen(curCharCount));
                }
            }
        }

        return dp[N][k];
    }

    private int getLen(int curCharCount) {
        if (curCharCount == 1) {
            return 1;
        } else if (curCharCount < 10) {
            return 2;
        } else if (curCharCount < 100) {
            return 3;
        } else {
            return 4;
        }
    }
}