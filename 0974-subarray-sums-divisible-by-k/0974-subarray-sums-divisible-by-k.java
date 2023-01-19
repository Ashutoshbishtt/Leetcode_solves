class Solution {

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for (int i : nums) {
            sum += i;
            map.put(((sum % k) + k) % k, map.getOrDefault(((sum % k) + k) % k, 0) + 1);
        }
        for (int i : map.keySet()) {
            int val = map.get(i);
            if (val > 1) res += ((val * (val - 1)) / 2);
        }

        return res + (map.get(0) != null ? map.get(0) : 0);
    }
}
