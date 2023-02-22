class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int right = 0, left = 0;
        for (int i : weights) {
            right += i;
            left = Math.max(left, i);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int i = 0, sum = 0;
            int cur = 0;
            while (i < weights.length) {
                sum += weights[i];
                if (sum == mid) {
                    cur++;
                    sum = 0;
                } else if (sum > mid) {
                    cur++;
                    sum = weights[i];
                }
                i++;
            }

            if (sum != 0) cur++;

            if (cur <= days) {
                right = mid;
            } else if (cur > days) {
                left = mid + 1;
            }
        }
        return left;
    }
}
