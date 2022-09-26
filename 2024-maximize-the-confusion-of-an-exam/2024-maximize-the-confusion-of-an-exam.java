class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int length = s.length();
        
        if (length == 0) {
            return 0;
        }
        
        int[] charToCountMap = new int[26];
        int i = 0;
        int j = 0;
        int maxCount = 0;
        
        while (i < length) {
            int count = ++charToCountMap[s.charAt(i)-'A'];

            if (count > maxCount) {
                maxCount = count;
            } else {
                k--;
            }

            if (k < 0) {
                --charToCountMap[s.charAt(j)-'A'];
                k++;
                j++;
            }
            
            i++;
        }
        
        return i-j;
    }
}