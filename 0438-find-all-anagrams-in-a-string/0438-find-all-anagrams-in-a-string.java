class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (s.length() < p.length()) return list;

        int N = s.length();
        int M = p.length();

        int count[] = freq(p);

        int current[] = freq(s.substring(0, M));

        if (areSame(count, current)) {
            list.add(0);
        }
        for (int i = M; i < N; i++) {
            current[s.charAt(i - M) - 'a']--;
            current[s.charAt(i) - 'a']++;
            if (areSame(count, current)) {
                list.add(i - M + 1);
            }
        }
        return list;
    }

    private boolean areSame(int[] count, int[] current) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != current[i]) return false;
        }
        return true;
    }

    private int[] freq(String p) {
        int[] arr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i) - 'a']++;
        }
        return arr;
    }
}
