class Solution {

    public int findLengthOfLCIS(int[] nums) {
        int res = 0, temp = 1;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int prev = nums[i - 1];

            if (prev < curr) {
                temp++;
            } else {
                res = Math.max(res, temp);
                temp = 1;
            }
        }
        return Math.max(res, temp);
    }
}
