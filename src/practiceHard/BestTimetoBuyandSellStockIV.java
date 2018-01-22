package practiceHard;

public class BestTimetoBuyandSellStockIV {
	
	public int maxProfit(int k, int[] prices) {
		if(prices == null || prices.length == 0){
			return 0;
		}
		int buy = Integer.MAX_VALUE, sell = 0;
		for(int i = 0; i < prices.length; i++){
			for(int j = 0; j < k; j++){
				buy = Math.min(buy, prices[i] - sell);
				sell = Math.max(sell, prices[i] - buy);
			}
		}
		return sell;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
