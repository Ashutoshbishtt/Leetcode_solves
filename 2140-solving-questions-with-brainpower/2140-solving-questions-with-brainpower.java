class Solution {

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] memo = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            long onSkippingThisQuestion = 0;
            long choosingThisQuestion = 0;
            if (i + 1 < n) {
                onSkippingThisQuestion = memo[i + 1];
            }
            if (i + questions[i][1] + 1 < n) {
                choosingThisQuestion = memo[i + questions[i][1] + 1];
            }
            memo[i] = Math.max(questions[i][0] + choosingThisQuestion, onSkippingThisQuestion);
        }
        return memo[0];
    }
}
