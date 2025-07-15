class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int n = prices.length;
        int pro = 0;
        for(int i=1;i<n;i++){
            int cost = prices[i]-mini;
            pro = Math.max(pro,cost);
            mini = Math.min(mini,prices[i]);
        }
        return pro;
    }
}