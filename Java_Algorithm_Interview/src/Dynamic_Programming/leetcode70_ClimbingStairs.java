package Dynamic_Programming;

public class leetcode70_ClimbingStairs {
	
	public int climbStairs(int n) {
		
		if ( n <=2 ){
            return n ;
        }
        int [] dp= new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for ( int i = 3 ; i <= n ; i ++){
			dp[i] = dp[i-1] + dp[i-2] ;
		}
		
        return dp[n];
    }

	
	public static void main(String[] args) {
		leetcode70_ClimbingStairs test1 = new leetcode70_ClimbingStairs();
		int ans = test1.climbStairs(5);
		System.out.println(ans);
	}
}
