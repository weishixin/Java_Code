package Dynamic_Programming;

public class leetcode121_BestTimeToBuyAndSellStock {
	
	//定义：max_profit = max{ prices[j]-prices[i]},0<=i < j <= n-1
	/*观察可得：
	 * Buy : prices[i]:min{prices[k]},k<= i
	 * Sell: prices[j]:max{prices[k]},k>= j
	 * */
	/*public int maxSubArray( int[] nums) {
		int [] f = new int[nums.length];
		f[0] = nums[0];
		
		for( int i = 1; i < nums.length ; i ++ ){
			f[i] = Math.max(f[i-1]+nums[i],  nums[i]);
		}
		int max0 = f[0];
		for ( int i = 1 ; i < nums.length ; i ++){
			if( f[i] > max0 ){
				max0 = f[i];
			}
		}
		return max0;
	}
	public int maxProfit( int [] prices){
		int n = prices.length;
		if( n < 2)
			return 0;
		int []gains = new int[n-1];
		for( int i = 0 ; i < gains.length ; i ++ ){
			gains[i] = 0 ;
		}
		for ( int i = 1 ; i < n ; i ++ ){
			gains[i-1] = prices[i] - prices[i-1];
		}
		return Math.max(0 , maxSubArray(gains)) ;//可以不抛出，所以要和0比较
	}*/
	
	public int maxProfit( int [] prices) {
		int n = prices.length;
		if ( n < 1 )
			return 0 ;
		int [] min_prices = new int[n];
		int [] max_profit = new int[n];
		min_prices[0] = prices[0] ;
		max_profit[0] = 0 ;
		for ( int i = 1 ; i < n ; i ++ ){
			min_prices[i] = Math.min(prices[i], min_prices[i-1]);
			
			max_profit[i] = Math.max(prices[i] - min_prices[i-1], max_profit[i-1]);
		}
		return max_profit[n-1] ;
	}
}
