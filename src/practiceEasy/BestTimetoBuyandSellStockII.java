package practiceEasy;

public class BestTimetoBuyandSellStockII {

	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0){
			return 0;
		}
		int profit = 0;
		for(int i = 0; i < prices.length - 1; i++){
			int max = Math.max(0, prices[i + 1] - prices[i]);
			profit += max;
		}
		return profit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
