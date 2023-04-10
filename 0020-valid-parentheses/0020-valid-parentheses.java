class Solution {

    public boolean isValid(String s) {
        Stack<Character> checker = new Stack<Character>();

        for (char a : s.toCharArray()) {
            if (a == '{') {
                checker.push('}');
            } else if (a == '(') {
                checker.push(')');
            } else if (a == '[') {
                checker.push(']');
            } else if (checker.isEmpty() || checker.pop() != a) {
                return false;
            }
        }
        return checker.isEmpty();
    }
}
