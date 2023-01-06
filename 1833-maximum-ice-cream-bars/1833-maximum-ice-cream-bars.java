class Solution {

    public int maxIceCream(int[] costs, int coins) {
        int count = 0;
        Arrays.sort(costs);
        for (int j : costs) {
            coins = coins - j;
            if (coins < 0) {
                break;
            }
            count++;
        }
        return count;
    }
}
