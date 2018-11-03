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
        
        //steps������¼ÿһ��Ĳ���
        HashMap<String, Integer> steps = new HashMap<String, Integer>();
        steps.put(beginWord, 1);
        //parents������¼ÿһ������ ��������Щ���ʱ仯�õ�
        HashMap<String, List<String>> parents = new HashMap<String, List<String>>();
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        //��ʼ��ans����
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
        				if( w.equals(endWord)){//�ǽ�β���� ����ʾ�Ѿ��ҵ�����
        					parents.get(w).add(p);
        					found = true;
        				}else{
        					//��֤��̣����ǵ�����������Ե���õ���
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
	
	/**�����洢���ս��*/
	List<List<String>> result;
	
	/**�����洢ĳһ�����*/
    List<String> tmp;
    
	 public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		 /**�����洢һ�����ʵ����ڵ���*/
		 Map<String,List<String>> map=new HashMap<String,List<String>>();
		 
		 /**��ʼ�������*/
		 result=new ArrayList<List<String>>();
		 tmp=new ArrayList<String>();
		 
		 /**�洢��ǰ��Ľ��*/
		 List<String> current=new ArrayList<String>();
		 /**�洢û�еı������ĵ���*/
		 List<String>  unvisited=wordList;
		 
		 /**���ȱ������ı��ǿ�ʼ�ĵ���*/
		 if(unvisited.contains(beginWord))
		 {
			 unvisited.remove(beginWord);
		 }
		 
		 /**δ�����Ľڵ��а��������ڵ�*/
		 unvisited.add(endWord);
		 /**��ʼ����ǰ��λ��ʼ�ڵ�*/
		 current.add(beginWord);
		 
		 while((!current.contains(endWord))&&unvisited.size()>0)
		 {
			 /**��ʼ����һ��ڵ�*/
			 List<String> nextstep=new ArrayList<String>();
			 
			 /**������ǰ��ڵ�*/
			 for(String word:current)
			 {
				 /**����������ǰ�ڵ��������*/
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
									 /**Ϊ���Ż��������������Ƿ���ͼ*/
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
			 /**���û����һ��ڵ㣬ֱ�ӷ���*/
			 if(nextstep.size()==0) return result;
			 
			 /**����һ�㣬ȥ���ò�ڵ㡣������ÿ�ҵ�һ���ڵ��ȥ��������©�����ܵ�·��*/
			 for(String news:nextstep)
			 {
				 unvisited.remove(news);
			 }
			 /**������һ��ı���*/
			 current=nextstep;
		 }
		 findPath(map,endWord,beginWord);
		 return result;
	    }
	 
	 /**���ݷ����ڽӱ�Ѱ�ұ���·��*/
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
			 /**�ݹ�ĺ�������*/
			 tmp.remove(tmp.size()-1);
		 }
	 }


}
