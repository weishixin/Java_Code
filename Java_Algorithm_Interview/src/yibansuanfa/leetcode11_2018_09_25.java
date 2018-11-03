package yibansuanfa;

public class leetcode11_2018_09_25 {

	public int maxArea( int [] height){
		int maxarea = 0 , l = 0 , r = height.length - 1;
		while( l < r ){
			maxarea = Math.max(maxarea, Math.min(height[l], height[r])*(r-l));
			if( height[l] < height[r]){
				l ++ ;
			}else {
				r -- ;
			}
		}
		return maxarea ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] height = { 1,8,6,2,5,4,8,3,7 };
		leetcode11_2018_09_25 a = new leetcode11_2018_09_25();
		System.out.println(a.maxArea(height));
	}

}
