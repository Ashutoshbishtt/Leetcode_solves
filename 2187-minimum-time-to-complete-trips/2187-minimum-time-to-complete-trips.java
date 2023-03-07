class Solution {

    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        long end = 0;
        for (int i : time) end = Math.max(end, i);
        end = end * totalTrips;
        while (low < end) {
            long mid = (low + end) / 2;
            long r = 0;
            for (int i : time) {
                if (i <= mid) {
                    r += mid / i;
                }
                if (r > totalTrips) break;
            }
            if (r < totalTrips) low = mid + 1; else end = mid;
        }
        return low;
    }
}
