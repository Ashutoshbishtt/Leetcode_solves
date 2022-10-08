class Solution {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            int freq = countMap.get(nums[i]);
            freqMap.put(freq, freqMap.getOrDefault(freq, 0) + 1);

            int count = freqMap.get(freq) * freq;
            if (count == i + 1 && i != nums.length - 1) {
                res = Math.max(res, i + 2);
            } else if (count == i) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }
}