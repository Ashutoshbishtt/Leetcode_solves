class Solution {

    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char charArr[] = s.toCharArray();
            Arrays.sort(charArr);
            return String.valueOf(charArr);
        } else {
            String newStr = s;
            for (int i = 0; i < s.length(); i++) {
                s = s.substring(1) + s.substring(0, 1);
                if (newStr.compareTo(s) > 0) {
                    newStr = s;
                }
            }
            return newStr;
        }
    }
}
