package Dynamic_Programming;

public class leetcode64_MinimumPathSum {
	
	/*
	 * ������dp[i][j]����ʾ �ڴӡ�0����0������λ�õ���̾��룬Ҳ�� ����Ľ�
	 * ���ǵ��Ż��ռ临�Ӷȣ���grid�������Ϊdp����
	 * ���õݹ�˼������
	 * */
	public int minPathSum( int [][] grid){
		//
		int m = grid.length;
		if ( m == 0 )
			return 0;
		int n = grid[0].length;
		
		for ( int i = 0 ; i < m ; i ++ ){
			for (int j = 0; j < n; j++) {
				if( i== 0 && j == 0 ){
					continue;
				}
				if( i == 0 ){
					grid[i][j] += grid[i][j-1];
				}else if( j == 0 ){
					grid[i][j] += grid[i-1][j];
				}else {
					grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
				}
			}
		}
		return grid[m-1][n-1];
		
	}
}
