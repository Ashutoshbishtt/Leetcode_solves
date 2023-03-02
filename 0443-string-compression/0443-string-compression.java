class Solution {

    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char prev = chars[0];
        int len = 1;
        for (int i = 1; i < chars.length; i++) {
            if (prev == chars[i]) {
                len++;
            } else {
                sb.append(prev);
                if (len != 1) {
                    sb.append(len);
                }
                len = 1;
            }
            prev = chars[i];
        }
        sb.append(prev);
        if (len != 1) {
            sb.append(len);
        }
        String str = sb.toString();
        int idx = 0;
        while (idx < str.length()) {
            chars[idx] = str.charAt(idx);
            idx++;
        }
        return str.length();
    }
}
