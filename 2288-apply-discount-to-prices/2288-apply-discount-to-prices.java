class Solution {

    boolean digitOnly(String s) {
        for (char cs : s.toCharArray()) if (cs != '$' && !(cs >= '0' && cs <= '9')) return false;
        return true;
    }

    public String discountPrices(String sentence, int discount) {
        double val = (double) discount / (double) 100;
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].indexOf('$') == 0 && s[i].lastIndexOf('$') == 0 && s[i].length() > 1 && digitOnly(s[i])) {
                double temp = 1.0 * Long.parseLong(s[i].substring(1));
                s[i] = "$" + String.format("%.2f", (temp - temp * val));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int sk = 0; sk < s.length; sk++) {
            sb.append(s[sk]);
            if (sk != s.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
