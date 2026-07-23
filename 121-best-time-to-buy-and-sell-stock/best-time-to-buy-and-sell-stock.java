class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int prevmin = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
            max = Math.max(max,prices[i]-prevmin);
            prevmin =Math.min(prevmin,prices[i]);
        }
        return max;
    }

}