class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
		int[][] temp = new int[n][2];
		for (int i = 0; i < temp.length; i++) {
			temp[i][0] = plantTime[i];
			temp[i][1] = growTime[i];
		}
		Arrays.sort(temp, (a, b) -> b[1] - a[1]);
		int max = 0;
		int cum = 0;
		for (int i = 0; i < temp.length; i++) {
			max = Math.max(max, cum + temp[i][0] + temp[i][1]);
			cum = cum + temp[i][0];
		}
		return max;
	}
}