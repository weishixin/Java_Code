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

	//curr相当于一个栈，用来记录当前访问过的路径，记下节点，并继续往下遍历，或者 回溯
	public void pathSum1(TreeNode root , int sum , List<Integer> curr ,List<List<Integer>> ans) {
		
		if( root == null){
			return ;
		}
		if ( root.left == null && root.right == null){
			if( root.val == sum){
				//下面两句是将curr数组，复制一份给mycopy,要不然处理起来都会改变curr本身，（毕竟传递的是地址值（引用））
				ArrayList<Integer> mycopy=new ArrayList<Integer>(Arrays.asList(new Integer[curr.size()]));
                Collections.copy(mycopy, curr);
                mycopy.add(root.val);//将本次最后的val值，放到拷贝好的List中去
				ans.add(mycopy);//把当前路径，添加到最终答案的List中去
			}
			return;		
		}
		
		curr.add(root.val);//记录下当前路径上的值到curr中
		int new_sum = sum - root.val ;	//计算剩下的和的值
		pathSum1(root.left, new_sum, curr, ans);	//递归遍历 左子树
		pathSum1(root.right, new_sum, curr, ans);	//递归遍历右子树
		curr.remove(curr.size()-1);	//回溯，（向栈一样）
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
