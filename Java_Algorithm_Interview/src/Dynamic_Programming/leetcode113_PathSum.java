package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class leetcode113_PathSum {

	//curr�൱��һ��ջ��������¼��ǰ���ʹ���·�������½ڵ㣬���������±��������� ����
	public void pathSum1(TreeNode root , int sum , List<Integer> curr ,List<List<Integer>> ans) {
		
		if( root == null){
			return ;
		}
		if ( root.left == null && root.right == null){
			if( root.val == sum){
				//���������ǽ�curr���飬����һ�ݸ�mycopy,Ҫ��Ȼ������������ı�curr�������Ͼ����ݵ��ǵ�ֵַ�����ã���
				ArrayList<Integer> mycopy=new ArrayList<Integer>(Arrays.asList(new Integer[curr.size()]));
                Collections.copy(mycopy, curr);
                mycopy.add(root.val);//����������valֵ���ŵ������õ�List��ȥ
				ans.add(mycopy);//�ѵ�ǰ·������ӵ����մ𰸵�List��ȥ
			}
			return;		
		}
		
		curr.add(root.val);//��¼�µ�ǰ·���ϵ�ֵ��curr��
		int new_sum = sum - root.val ;	//����ʣ�µĺ͵�ֵ
		pathSum1(root.left, new_sum, curr, ans);	//�ݹ���� ������
		pathSum1(root.right, new_sum, curr, ans);	//�ݹ����������
		curr.remove(curr.size()-1);	//���ݣ�����ջһ����
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        pathSum1(root, sum, curr, ans);
        
        return ans;
    }
	
	
//	public static void main(String[] args) {
//		
//		List<Integer> curr = new ArrayList<Integer>();
//		curr.add(12);
//		curr.add(14);
//		curr.add(15);
//		curr.remove(curr.size()-1);
////		ArrayList<Integer> curr2 = new ArrayList<Integer>();
////		curr2 = (ArrayList<Integer>) curr;
////		ArrayList<Integer> curr_copy = new ArrayList<Integer>();
////		curr_copy = curr.clone();
//		ArrayList<Integer> mycopy=new ArrayList<Integer>(Arrays.asList(new Integer[curr.size()]));
//		Collections.copy(mycopy, curr);
//		for( int i = 0 ; i< mycopy.size() ; i ++ ){
//			System.out.println(curr.get(i));
//		}
//	}
}
