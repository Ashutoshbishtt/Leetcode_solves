class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> mpp = new HashMap<String, ArrayList<String>>();

        for (String st : strs) {
            char[] ch = st.toCharArray();
            Arrays.sort(ch);
            String ss = String.valueOf(ch);
            if (!mpp.containsKey(ss)) mpp.put(ss, new ArrayList<String>());
            mpp.get(ss).add(st);
        }
        return new ArrayList<>(mpp.values());
    }
}
