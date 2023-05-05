class Solution {

    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int ans = 0, i = 0, j = 0, len = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);

            if (vowels.contains(ch)) len++;

            if (j - i + 1 == k) {
                ans = Math.max(ans, len);

                if (vowels.contains(s.charAt(i))) len--;

                i++;
            }

            j++;
        }

        return ans;
    }
}
