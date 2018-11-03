package Dynamic_Programming;

public class leetcode64_MinimumPathSum {
	
	/*
	 * 这里用dp[i][j]来表示 在从【0】【0】到该位置的最短距离，也即 问题的解
	 * 考虑到优化空间复杂度，把grid数组就作为dp数组
	 * 利用递归思想来做
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
