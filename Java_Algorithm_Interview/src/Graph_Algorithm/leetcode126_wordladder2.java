package Graph_Algorithm;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class leetcode126_wordladder2 {

	/*public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> wdlist = new ArrayList(wordList);
        if( !wdlist.contains(endWord)){
        	return null;
        }
        wdlist.remove(beginWord);
        wdlist.remove(endWord);
        
        //steps用来记录每一层的步长
        HashMap<String, Integer> steps = new HashMap<String, Integer>();
        steps.put(beginWord, 1);
        //parents用来记录每一个单词 可以由哪些单词变化得到
        HashMap<String, List<String>> parents = new HashMap<String, List<String>>();
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        //初始化ans数组
        List<List<String>> ans = new ArrayList(wordList);
        
        int l = beginWord.length();
        int step = 0 ;
        boolean found = false;
        
        while( !q.isEmpty() && !found){
        	++ step ;
        	for ( int size = q.size() ; size>0 ; size -- ){
        		String p = q.poll();
        		String w = p ;
        		for ( int i = 0 ; i < l ; i ++){
        			char ch = w.charAt(i);
        			for( int j = 'a' ; j <= 'z' ; j ++){
        				if( ch == j ){
        					continue;
        				}

        				StringBuilder strBuilder = new StringBuilder(w);
        				strBuilder.setCharAt(i,(char)(j) );
        				if( w.equals(endWord)){//是结尾单词 ，表示已经找到解了
        					parents.get(w).add(p);
        					found = true;
        				}else{
        					//保证最短，考虑到其他情况可以到达该单词
        					if( steps.containsKey(w)&& step < steps.get(w)){
        						parents.get(w).add(p);
        					}
        				}
        				if ( ! wdlist.contains(w))
        					continue;
        				wdlist.remove(w);
        				q.add(w);
        				
        				steps.put(w, steps.get(p)+1);
        				parents.get(w).add(p);
        			}
        			StringBuilder strBuilder2 = new StringBuilder(w);
    				strBuilder2.setCharAt(i,ch );
        		}
        	}
        }
        if( found ){
    		List<String> curr = new ArrayList<String>();
    		curr.add(endWord);
    		getPaths(endWord,beginWord,parents,curr,ans);
    	}
        return ans;
    }
	
	public void getPaths( String word , String beginword , 
			HashMap<String, List<String>> parents , List<String> curr , List<List<String>> ans){
		List<String> temp = new ArrayList<String>();
		if ( word == beginword){
			Iterator<String> iterator = curr.iterator();
			while(iterator.hasNext()){
				temp.add(iterator.next());
			}
			ans.add(temp);
			return;
		}
		
		
		for( String p : parents.get(word)){
			curr.add(p);
			getPaths(p, beginword, parents, curr, ans);
			curr.remove(p);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leetcode126_wordladder2 a = new leetcode126_wordladder2();
		
		
	}*/
	
	/**用来存储最终结果*/
	List<List<String>> result;
	
	/**用来存储某一条结果*/
    List<String> tmp;
    
	 public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		 /**用来存储一个单词的相邻单词*/
		 Map<String,List<String>> map=new HashMap<String,List<String>>();
		 
		 /**初始化结果集*/
		 result=new ArrayList<List<String>>();
		 tmp=new ArrayList<String>();
		 
		 /**存储当前层的结果*/
		 List<String> current=new ArrayList<String>();
		 /**存储没有的遍历到的单词*/
		 List<String>  unvisited=wordList;
		 
		 /**首先遍历到的便是开始的单词*/
		 if(unvisited.contains(beginWord))
		 {
			 unvisited.remove(beginWord);
		 }
		 
		 /**未遍历的节点中包含结束节点*/
		 unvisited.add(endWord);
		 /**初始化当前层位开始节点*/
		 current.add(beginWord);
		 
		 while((!current.contains(endWord))&&unvisited.size()>0)
		 {
			 /**初始化下一层节点*/
			 List<String> nextstep=new ArrayList<String>();
			 
			 /**遍历当前层节点*/
			 for(String word:current)
			 {
				 /**暴力搜索当前节点相近单词*/
				 for(int i=0;i<word.length();i++)
				 {
					 char ch=word.charAt(i);
					 for(int j=0;j<26;j++)
					 {
						 if(ch=='a'+j)
							 continue;
						 else
						 {
							 char c=(char) ('a'+j);
							 String tmpword="";
							 if(i==0)
							 {
								 tmpword=c+word.substring(i+1);
							 }
							 else
							 {
								 tmpword=word.substring(0,i)+c+word.substring(i+1);
							 }
							 if(unvisited.contains(tmpword))
							 {
								 nextstep.add(tmpword);
								 if(map.containsKey(tmpword))
								 {
									 List<String> set=map.get(tmpword) ;
									 set.add(word);
									 /**为了优化搜索，构建的是反向图*/
									 map.put(tmpword, set);
								 }
								 else
								 {
									 List<String> l1=new ArrayList<String>();
									 l1.add(word);
									 map.put(tmpword, l1);
								 }
							 }
						 }
						 
					 }
				 }
				 
				 
			 }
			 /**如果没有下一层节点，直接返回*/
			 if(nextstep.size()==0) return result;
			 
			 /**找完一层，去掉该层节点。而不是每找到一个节点就去掉，避免漏掉可能的路径*/
			 for(String news:nextstep)
			 {
				 unvisited.remove(news);
			 }
			 /**继续下一层的遍历*/
			 current=nextstep;
		 }
		 findPath(map,endWord,beginWord);
		 return result;
	    }
	 
	 /**根据反向邻接表寻找遍历路径*/
	 public void findPath(Map<String,List<String>> map,String start,String end)
	 {
		 
		 tmp.add(start);
		 if(start.equals(end))
		 {
			 List<String> ret=new ArrayList<String>(tmp);
			 Collections.reverse(ret);
			 result.add(ret);
			 return;
		 }
		 List<String> l2=map.get(start);
		 for(String s:l2)
		 {
			 findPath(map,s,end);
			 /**递归的后续处理*/
			 tmp.remove(tmp.size()-1);
		 }
	 }


}
