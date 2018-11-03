package Graph_Algorithm;

public class leetcode200_Number_Of_Islands {

	public int numIslands(char[][] grid) {
		
		if( grid.length==0){
			return 0;
		}
		//获得长和宽
		int m = grid.length;
		int n = grid[0].length;
		int ans = 0;
		for( int y = 0 ; y < m ;y++){
			for( int x = 0 ; x < n ; x++){
				if( grid[y][x] == '1'){
					ans ++;
					dfs( grid , x , y , m , n );
				}
			}
		}
		
        return ans;
    }
	
	public void dfs( char[][] grid , int x , int y , int m , int n ){
		if( x < 0 || x >= n || y < 0 || y >= m || grid[y][x] == '0'){
			return;
		}
		
		grid[y][x] = '0';
		//递归遍历周围
		dfs(grid, x+1, y, m, n);
		dfs(grid, x-1, y, m, n);
		dfs(grid, x , y+1, m, n);
		dfs(grid, x, y-1 , m, n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
