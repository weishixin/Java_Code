package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class leetcode120_Triangle {

	//[2]
	//[3],[4]
	//[6],[5],[7]
	//[4],[1],[8],[3]
	
	public int minimumTotal(List<List<Integer>> triangle) {
		
		//f[i][j] = minTotalOf(i,j) ��ʾ���������ߵ����Ԫ�ص���Сֵ �Ƕ���
		//״̬ת�Ʒ��̣� 
		//f[i][j] = min( f[i-1][j-1],f[i-1][j]) + triangle[i][j]
		int n = triangle.size();
//		List<List<Integer>> f = new ArrayList<List<Integer>>(n+1);
//		for( int i = 0 ; i<= f.size() ; i ++ ){
//			List<Integer> temp = new ArrayList<Integer>(n+1);
//			for( int j = 0 ; j < temp.size() ; j ++ ){
//				temp.add(Integer.MAX_VALUE);
//			}
//			f.add(temp);
//		}
//		
//		for( int i = 1 ; i <= n ; i ++ ){
//			for ( int j = 1 ;j <= i ; j ++ ){
//				f.get(i).add(e)
//			}
//		}
		
		//���ţ�ֱ����triangle������ ������ ��ֵ
		
		for ( int i = 0 ; i < n ; i ++ ){
			for ( int j = 0 ; j <= i; j ++ ){
				if( i ==0 && j == 0 ){
					continue;
				}
				if( j == 0 ){//��һ��
					triangle.get(i).set(j, triangle.get(i-1).get(j)+triangle.get(i).get(j));
				}
				else if( j == i ){
					triangle.get(i).set(j, triangle.get(i-1).get(j-1)+triangle.get(i).get(j));
				}else{
					triangle.get(i)
					.set(j,
					Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1))
					+ triangle.get(i).get(j));
				}
			}
		}
		//�����ҳ�triangle��������һ�е���Сֵ
		int ans = Integer.MAX_VALUE;
		for( int i = 0 ; i < triangle.get(n-1).size();i++){
			if( triangle.get(n-1).get(i) < ans){
				ans = triangle.get(n-1).get(i) ;
			}
		}
        return ans ;
    }
}
