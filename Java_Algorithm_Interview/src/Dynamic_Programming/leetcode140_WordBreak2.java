package Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leetcode140_WordBreak2 {
//	 List <String> result ;
	 
//	 public List<String> wordBreak(String s, List<String> wordDict) {
//		 result = new ArrayList<String>();
//		 int n = s.length();
//		 //��ÿһ��i�� �γ�һ��������Ծ�ĵ�
//		 List <Integer> [] pointer = new List[n];
//		 for ( int i = 0 ; i < n ; i ++ ){
//			 pointer[i] = new ArrayList<Integer>();
//		 }
//		 
//		 //�ȼ��¿��Էָ�� s�е�����ֵ
//		 for ( int i = 0 ; i < n ; i ++ ){
//			 for( int j = 0 ; j <= i ; j++){
//				 if ( wordDict.contains(s.substring(j, i+1)) && ( j== 0 || pointer[j-1].size()>0)){
//					 pointer[i].add(j);
//				 }
//			 }
//		 }
//		 //���ԴӺ���ǰ�ݹ�
//		 helper(pointer, s, n-1, "");
//		 
//		 return result;
//	 }
//	 
////	 public List<String> append( List<String> prefix , String word) {
////		 List<String> result;
////		 Iterable  it = result.iterator();
////		 while( ):
////		
////	}
//	
//	 //������DFS
//	 public void helper( List<Integer> [] pointer , String s , int i , String pattern){
//		 if ( i < 0 ){
//			 result.add(pattern);
//			 return ;
//		 }
//		 for( Integer item: pointer[i]){//��Ҫ������i�����µ����п��ܵ����
//			 String nextpattern = pattern.length()==0 ? s.substring(item, i+1):s.substring(item, i+1)+" "+pattern;
//			 helper(pointer, s, item-1, nextpattern);
//		 }
//	 }
	
	 Map<String, List<String> > mem_ = new HashMap<String, List<String>>();
	 
	 public List<String> wordBreak(String s, List<String> wordDict) {
		 if ( mem_.containsKey(s))
			 return mem_.get(s);
		 
		 List<String> ans = new ArrayList<String>();
		 
		 if( wordDict.contains(s)){
			 ans.add(s);
		 }
		 
		 for( int i = 1; i < s.length() ; i ++){
			 String right = s.substring(i);
			 if( !wordDict.contains(right)){
				 continue;
			 }
			 
			 String left = s.substring(0, i);
			 List<String> left_ans = append(wordBreak(left, wordDict), right);
			 
			 ans.addAll(left_ans);
		 }
		 
		 mem_.put(s, ans);
		 
		 return mem_.get(s);
	 }
	 
	 
	 public List<String> append( List<String> prefixs , String word ){
		 List<String> results = new ArrayList<String>();
		 for( int i = 0 ; i < prefixs.size() ; i ++){
			 results.add( prefixs.get(i) + " " + word);
		 }
		 return results;
	 }
	 
		 
		 
}
