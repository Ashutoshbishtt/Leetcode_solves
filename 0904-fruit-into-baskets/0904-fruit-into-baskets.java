class Solution {

    public int totalFruit(int[] fruits) {
        int ans = 0, j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[j], map.get(fruits[j]) - 1);
                if (map.get(fruits[j]) == 0) {
                    map.remove(fruits[j]);
                }
                j++;
            }
            ans = Math.max(i - j + 1, ans);
        }
        return ans;
    }
}
