class Solution {
    public int maxProfit(int[] prices) {
        int profit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        
        if (prices.length == 0) {
            return 0;
        }
        
        // save the previous value so you can compare
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(prices[i] - minPrice, profit);
        }
        
        return profit;
    }
}