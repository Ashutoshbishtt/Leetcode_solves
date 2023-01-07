class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            return -1;
        }

        int gasSum = 0, possible = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i] - cost[i];

            if (gasSum < 0) {
                possible = i + 1;
                gasSum = 0;
            }
        }
        return gasSum >= 0 ? possible : -1;
    }
}
