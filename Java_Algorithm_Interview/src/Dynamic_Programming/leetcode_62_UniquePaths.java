package Dynamic_Programming;

public class leetcode_62_UniquePaths {
	
	public int uniquePaths( int m , int n ){
		if ( m < 0 || n < 0 ){
			return 0 ;
		}
		int [][]f = new int[n+1][m+1]; //f[i][j]表示 从起点到点（i,j）所有可能的步数总和
		f[1][1] = 1;
		
		for ( int y = 1 ; y <= n ; y ++ ){
			for( int x = 1 ; x <= m ; x ++ ){
				if (x == 1 && y == 1){
					continue ;
				}else {
					f[y][x] = f[y-1][x] + f[y][x-1] ;
				}
			}
		}
		return f[n][m];
	}
	
	public static void main(String[] args) {
		leetcode_62_UniquePaths up = new leetcode_62_UniquePaths();
		
		System.out.println( up.uniquePaths(3, 2));
	}
}
