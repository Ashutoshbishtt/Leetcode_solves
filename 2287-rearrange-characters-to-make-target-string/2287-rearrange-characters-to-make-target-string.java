class Solution {

    public int rearrangeCharacters(String s, String target) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : s.toCharArray()) freq1[c - 'a']++;
        for (char c : target.toCharArray()) freq2[c - 'a']++;

        int min = Integer.MAX_VALUE;
        for (char ch : target.toCharArray()) min = Math.min(min, freq1[ch - 'a'] / freq2[ch - 'a']);
        return min;
    }
}
