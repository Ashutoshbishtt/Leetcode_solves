class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        char[] dictionary = new char[26];

        for (int i = 0; i < order.length(); i++) {
            char c = (char) ('a' + i);
            dictionary[order.charAt(i) - 'a'] = c;
        }

        boolean firstWord = true;
        String previous = "";
        StringBuilder current = new StringBuilder("");

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char currentChar = dictionary[word.charAt(i) - 'a'];
                current.append(currentChar);
            }

            if (firstWord) {
                firstWord = false;
                previous = current.toString();
                current.setLength(0);
                continue;
            }

            if (previous.compareTo(current.toString()) > 0) {
                return false;
            }

            previous = current.toString();
            current.setLength(0);
        }

        return true;
    }
}
