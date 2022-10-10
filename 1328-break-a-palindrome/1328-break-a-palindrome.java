class Solution {

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        } else {
            char[] pp = palindrome.toCharArray();
            for (int i = 0; i < pp.length / 2; i++) {
                if (pp[i] != 'a') {
                    pp[i] = 'a';
                    return (new String(pp));
                }
            }
            pp[pp.length - 1] = 'b';
            return (new String(pp));
        }
    }
}
