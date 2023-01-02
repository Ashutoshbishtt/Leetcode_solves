class Solution {

    public boolean detectCapitalUse(String word) {
        boolean islower = true, isupper = true;
        for (int i = 1; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) isupper = false; else islower = false;
        }
        return islower || (isupper && Character.isUpperCase(word.charAt(0)));
    }
}
