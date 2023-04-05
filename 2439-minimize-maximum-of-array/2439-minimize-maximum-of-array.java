class Solution {

    public int minimizeArrayValue(int[] nums) {
        int max = nums[0];
        long buf = max;
        for (int i = 1; i < nums.length; i++) {
            buf = nums[i] - (max - buf);
            if (buf > max) {
                int d = Math.toIntExact(buf - max);
                max += (d + i) / (i + 1);
                buf = max - (d % (i + 1) != 0 ? (i + 1 - d % (i + 1)) : 0);
            }
        }
        return max;
    }
}
