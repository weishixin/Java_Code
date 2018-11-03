package Array;

import java.util.Iterator;

class ListNode{
	int val;
	ListNode next ;
	ListNode(int x ){ val = x ;}
}

public class leetCode_2 {
	
//	public long nodeToInt( ListNode node ){
//		long result = 0;
//		result += node.val ;
//		node = node.next;
//		long xishu = 10;
//		while (node != null) {
//			result += xishu * node.val;
//			xishu = xishu*10;
//			node = node.next;
//		}
//		return result;
//	}
//	
//	public ListNode intToNode( long n ){
//		ListNode retNode = new ListNode(-1);
//		if( n >= 10 ){
//			retNode.val = n%10;
//			n = n/10 ;
//			ListNode currentNode = retNode ;
//			while( n != 0 ){
//				ListNode newNode = new ListNode(-1);
//				int single = n % 10 ;
//				newNode.val = single;
//				currentNode.next = newNode;
//				currentNode = currentNode.next;
//				n = n/10;
//			}
//		}
//		else{
//			retNode.val = n ;
//		}
//		return retNode;
//		
//	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode retnode = new ListNode(-1);
		ListNode p , q ,cur;
		p = l1;
		q = l2;
		cur = retnode;
		int carry = 0;
		while( q != null || p != null ){
			int a1 ,a2;
			if ( p!= null ){
				a1 = p.val;
			}else{
				a1=0;
			}
			if ( q!= null ){
				a2 = q.val;
			}else{
				a2=0;
			}
			int sum = carry + a1 + a2 ;
			carry = sum / 10;
			
			ListNode node = new ListNode(sum%10);
			cur.next = node;
			cur = cur.next;
			if (p != null) p = p.next;
	        if (q != null) q = q.next;
		}
		if (carry > 0) {
		        cur.next = new ListNode(carry);
		}
	
		retnode = retnode.next;
		return retnode;
	    
	}
	
	/*public void print(ListNode n ) {
		while( n != null ){
			System.out.printf("%d ",n.val);
			n = n.next;
		}
	}*/
	public static void main(String[] args) {
		leetCode_2 a = new leetCode_2();
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(1);
//		System.out.println(a.nodeToInt(node1));
//		System.out.println(a.nodeToInt(node2));
		
		int count = 0 ;
		ListNode cur1 = node2;
		while( count <= 8 ){
			ListNode l1 = new ListNode(9);
			cur1.next = l1;
			cur1 = cur1.next;
			count++;
		}
//		System.out.println(a.nodeToInt(node2));
//		System.out.println(a.nodeToInt(node1));
//		cur1 = cur1.next;
//		a.print(node2);
		System.out.println();
//		a.print(node1);
		System.out.println();
//		count = 0;
//		ListNode cur2 = node2;
//		while( count <= 2 ){
//			ListNode l1 = new ListNode(3);
//			cur2.next = l1;
//			cur2 = cur2.next;
//			count++;
//		}
//		System.out.println("--------------");
//		a.print(node1);
//		System.out.println();
//		System.out.println("----------");
//		System.out.println(a.nodeToInt(node1));
//		System.out.println(a.nodeToInt(node2));
		
//		ListNode test1 = a.intToNode(4535325);
		ListNode ans = a.addTwoNumbers(node1, node2);
//		a.print(ans);
//		while( test1!=null){
//			System.out.printf("%d ",test1.val);
//			test1=test1.next;
//		}
	}
}
