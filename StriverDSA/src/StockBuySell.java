class StockBuySell {
    public int maxProfit(int[] prices) {

        // Maintain variable for minValue so far and maxProfit so far

        // loop through array, if (arr[i] - minValue) > maxProfit, then update maxProfit

        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i=0;i<prices.length;i++) {
            // update minValue
            minValue = Math.min(minValue, prices[i]);

            // update maxProfit
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }

        return maxProfit;
    }
}