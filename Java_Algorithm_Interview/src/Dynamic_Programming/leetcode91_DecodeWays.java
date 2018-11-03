package Dynamic_Programming;

import java.lang.invoke.ConstantCallSite;
import java.util.HashMap;
import java.util.Map;

public class leetcode91_DecodeWays {

//	HashMap<String, Integer> m_ways = new HashMap<String, Integer>(); 
//	
//	//递归法
//	public int numDecodings( String S ){
//		
//		if( S.length() == 0 )
//			return 0;
//		m_ways.put("",1);
//		
//		return ways(S);
//	}
//	
//	public int ways( String s ){
//		
//		if( m_ways.containsKey(s))
//			return m_ways.get(s);
//		if( s.charAt(0)=='0'){
//			return 0;
//		}
//		if ( s.length() == 1 )
//			return 1;
//		int w = ways(s.substring(1, s.length()));
//		//Java中的substring函数（beginIndex ，endIndex）
//		//返回：从beginIndex位置到endIndex位置内的字符串(即，最后一个截取的字符在原串中的索引是endIndex-1)
//		int prefix = (s.charAt(0)-'0')*10 + (s.charAt(1)-'0');
//		if( prefix <= 26 ){
//			w += ways(s.substring(2, s.length()));
//		}
//		
//		m_ways.put(s, w);
//		return w ;
//	}
//	
//	public boolean isValid( char c ){
//		return c!='0';
//	}
//	public boolean isValid( char c1 , char c2 ){
//		int num = (c1-'0')*10 + (c2-'0');
//		return num>=10&& num<=26;
//	}
//	
//	public int numDecodings( String s ){
//		if( s.length()==0|| s.charAt(0)=='0'){
//			return 0 ;
//		}
//		if( s.length() == 1){
//			return 1 ;
//		}
//		
//		int n = s.length();
//		int w1 = 1 ;	//相当于dp[i-1],滚动临时变量
//		int w2 = 1;		//相当于dp[i-2]，滚动数组
//		for( int i = 1 ; i < n ; i ++ ){
//			int w = 0 ;
//			if(! isValid(s.charAt(i)) && !isValid(s.charAt(i-1),s.charAt(i))){
//				return 0 ;
//			}
//			if( isValid(s.charAt(i))){
//				w = w1 ;
//			}
//			if( isValid(s.charAt(i-1),s.charAt(i))){
//				w += w2 ;
//			}
//			w2 = w1 ;//滚动数组
//			w1 = w ;
//		}
//		return w1 ;
//	}
	
	public boolean isValid( char c ){
		return c!='0';
	}
	public boolean isValid( char c1, char c2){
		int n = ( c1 - '0')*10 + (c2-'0');
		return n >= 10 && n <= 26 ;
	}
	
	public int numDecodings( String s) {
		
		if( s.length() == 0 || s.charAt(0) =='0'){
			return 0 ;
		}
		if( s.length() == 1 ){
			return 1 ;
		}
		
		int w1 = 1;//w1相当于dp[i-1]
		int w2 = 1;//w2相当于dp[i-2] 这里作为滚动变量，来减小空间复杂度
		for ( int i = 1 ; i < s.length() ; i ++ ){
			int w = 0 ;
			if( isValid(s.charAt(i))){
				w = w1 ;
			}
			if( isValid(s.charAt(i-1) , s.charAt(i))){
				w += w2 ;
			}
			w2 = w1;//如果先赋值给w2，即执行（w1 = w , w2 = w1）,则w1的值已经变了,w2必须存放老的w1作为新的dp[i-2]
			w1 = w;//因此必须这样做
		}
		return w1;
	}
}
