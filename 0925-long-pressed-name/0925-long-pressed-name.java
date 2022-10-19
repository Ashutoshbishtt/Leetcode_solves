class Solution {

    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();
        int j = 0;
        char last = '@';

        for (int i = 0; i < m; i++) {
            if (j < n && name.charAt(j) == typed.charAt(i)) {
                last = typed.charAt(i);
                j++;
            } else if (typed.charAt(i) != last) {
                return false;
            }
        }

        return j == n;
    }
}
