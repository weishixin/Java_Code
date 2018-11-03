package Dynamic_Programming;

public class leetcode375_GusessNumberHigherOrLower2 {

	public int getMoneyAmount(int n) {
		
		if ( n <= 2 ){
			return n-1;
		}
		//dp数组 用老表示从i到j之间的猜中任意一个数字 所需要的最小花费
		int [][] dp = new int[n+1][n+1];
		for( int i = 0 ; i < n+1 ; i ++){//初始化
			for( int j = 0 ; j < n+1 ; j ++){
				dp[i][j] = 0;
			}
		}
		
		for ( int i = 2 ; i <= n ; i ++){
			for ( int j = i - 1 ; j > 0 ; j -- ){//这里的j到i的顺序 可以保证递推时，子集都已经计算过
				int global = Integer.MAX_VALUE ;
				int local = 0 ;
				//下面计算 j和 i之间 找一个值k, 然后比较j到k-1和 k+1到i之间的dp值，并选择两者的最大值，这是为了cover最坏情况
				//这里考虑最差的情况，即不考虑一下子所要猜的值就是k本身
				for( int k = j+1 ; k < i ; k ++){
					local = Math.max(dp[j][k-1], dp[k+1][i]) + k ;//计算局部最大花费
					global = Math.min( global , local);//遍历比较，得到i到j上的能猜出任意数字的 最小代价（钱）
				}
				dp[j][i] = j+1 == i ? j:global;//注意如果j和i相邻，直接得出j，否则得出global
			}
		}
        return dp[1][n];
    }
	
	//更好的解答
//	public int getMoneyAmount(int n) {
//        int[][] dp = new int[n+1][n+1];
//        return needMoneyMustWin(1,n,dp);
//    }
//    public int needMoneyMustWin(int from,int to,int dp[][]){
//        if(from >= to){
//            return 0;
//        }
//        if(from >= to-2){  //如: [1,2] [1,2,3]
//            return to-1;
//        }
//        if(dp[from][to] != 0){
//            return dp[from][to];
//        }
//        int min = Integer.MAX_VALUE;
//        //在[from,to]区间中 需要多少钱 保证赢? 只要假设选择的数落在了上半区间[from-to的中间开始 , to] 计算出来的数就是满足的题意的
//        for(int i = (from+to)/2-1; i <= to; i++){
//            int left = needMoneyMustWin(from,i-1,dp);
//            int right = needMoneyMustWin(i+1,to,dp);
//            int max = i + Math.max(0 , Math.max(left,right));
//            min = Math.min(max,min);
//        }
//        dp[from][to] = min;
//        return dp[from][to];
//    }
}
