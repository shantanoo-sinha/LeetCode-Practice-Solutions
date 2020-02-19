/*

Reference: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/ engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.

Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*/

class Solution {
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int maxReturn = 0;
        
        for(int i=0;i<prices.length;i++){
            if(minVal>prices[i]){
                minVal = prices[i];
            }
            else if(minVal<prices[i]){
                maxReturn = maxReturn + Math.max(0, prices[i]-minVal);
minVal = prices[i];
            }
        }
        return maxReturn;
    }
}
