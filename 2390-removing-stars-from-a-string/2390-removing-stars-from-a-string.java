class Solution {

    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') st.pop(); else st.push(s.charAt(i));
        }

        while (!st.isEmpty()) {
            ans = st.pop() + ans;
        }
        return ans;
    }
}
