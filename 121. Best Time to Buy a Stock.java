// Easy. Sliding Window.
// July 14.
class Solution {
    public int maxProfit(int[] prices) {
        int pointer = 1;

        int currentMin = prices[0];
        int maxProfit = 0;

        while (pointer < prices.length) {
            int val = prices[pointer];
            if (val > currentMin) {
                maxProfit = Math.max(maxProfit, val - currentMin);
            }
            else if (val < currentMin) {
                currentMin = val;
            }
            pointer++;
        }

        return maxProfit;
    }
}
