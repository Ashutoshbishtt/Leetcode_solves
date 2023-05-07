class Solution {

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        int[] lis = new int[n];
        int lenSoFar = 0;

        for (int i = 0; i < n; i++) {
            int low = 0, high = lenSoFar;

            while (low < high) {
                int mid = (low + high) >> 1;
                if (lis[mid] <= obstacles[i]) low = mid + 1; else high = mid;
            }
            if (low == lenSoFar) lenSoFar++;
            lis[low] = obstacles[i];
            ans[i] = low + 1;
        }

        return ans;
    }
}
