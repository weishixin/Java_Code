package Dynamic_Programming;

public class leetcode72_EditDistance {
	int [][] d;
	
//	/*
//	 * 以下为记忆化递归
//	 * */
//	public int minDistance( String word1 , String word2 ){
//		int l1 = word1.length();
//		int l2 = word2.length();
//		d = new int[l1+1][l2+1];
//		for ( int i = 0 ; i< l1+1 ; i ++ ){
//			for ( int j = 0 ; j <l2 + 1 ; j++ ){
//				d[i][j] = -1;
//			}
//		}
//		return minDistance1(word1, word2 , l1 , l2) ;
//	}
//	
//	//minDistance1 把 word1[0:l1-1] 变成 word2[0:l2-1],即实现题目的要求，每一次都比照最后一个字符串的元素
//	private int minDistance1( String word1 , String word2 , int l1 , int l2) {
//		if (l1 == 0) {//word1为空串，变为l2的步骤，需要l2步，（添加）
//			return l2 ;
//		}
//		if (l2 == 0){
//			return l1;
//		}
//		if ( d[l1][l2]>=0){
//			return d[l1][l2];
//		}
//		int ans ;
//		if( word1.charAt(l1-1) == word2.charAt(l2-1)){
//			ans = minDistance1(word1, word2, l1-1, l2-1);
//		}else {
//			ans = Math.min(minDistance1(word1, word2, l1-1, l2-1), 
//					Math.min(minDistance1(word1, word2, l1-1, l2), minDistance1(word1, word2, l1, l2-1))) + 1;
//		}//不好用三个最小，只能两个两个的套起来
//		return d[l1][l2]=ans ;
//	}
	
//	int [][]d;
	public int minDistance( String word1 , String word2 ){
	        int l1 = word1.length();
	        int l2 = word2.length();
	        d = new int [l1+1][l2+1];
	        for( int i = 0 ; i < l1+1 ; i ++ ){
	        	d[i][0] = i ;
	        }
	        for( int j = 0 ; j < l2+1 ; j ++ ){
	        	d[0][j] = j ;
	        }
	        
	        for( int i = 1 ; i<= l1 ; i++){
	        	for( int j = 1 ; j <= l2 ; j ++ ){
	        		int c = ( word1.charAt(i-1) == word2.charAt(j-1) )?0:1;
	        		d[i][j] = Math.min(d[i-1][j-1] + c, 
	        				Math.min(d[i-1][j] , d[i][j-1]) + 1);
	        		//巧妙运用c代价，如果a[i]==b[j],c=0,则d[i-1][j-1]必定小于d[i-1][j-1]+1(这个是后面计算replace的代价),,
	        		//若a[i]!=b[j],c=1,则d[i-1][j-1]+1，正好与min(d[i-1][j],d[i][j-1])+1比较，从而得出递推方程
	        	}
	        }
	        return d[l1][l2];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
