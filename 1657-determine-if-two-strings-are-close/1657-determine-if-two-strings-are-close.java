class Solution {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        countFreq(word1, freq1);
        countFreq(word2, freq2);
        int n = word1.length();
        int[] freqCount1 = new int[n + 1];
        int[] freqCount2 = new int[n + 1];
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > 0) {
                freqCount1[freq1[i]]++;
                if (freq2[i] == 0) return false;
            }
            if (freq2[i] > 0) {
                freqCount2[freq2[i]]++;
                if (freq1[i] == 0) return false;
            }
        }
        for (int i = 0; i < n + 1; i++) if (freqCount1[i] != freqCount2[i]) return false;
        return true;
    }

    private void countFreq(String str, int[] freq) {
        for (char c : str.toCharArray()) freq[c - 'a']++;
    }
}
