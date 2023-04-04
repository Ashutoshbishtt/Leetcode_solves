class Solution {

    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 1, i = 0;
        while (i < s.length()) {
            if (!set.add(s.charAt(i))) {
                count++;
                set.clear();
            } else i++;
        }
        return count;
    }
}
