class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        
        for(int i = 0; i < prices.length ; i++){
            minPrice = Math.min(minPrice,prices[i]);
            maxProfit = Math.max(prices[i]-minPrice,maxProfit);
        }
        return maxProfit;
    }
}