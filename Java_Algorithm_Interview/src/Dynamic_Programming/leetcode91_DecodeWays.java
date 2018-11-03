package Dynamic_Programming;

import java.lang.invoke.ConstantCallSite;
import java.util.HashMap;
import java.util.Map;

public class leetcode91_DecodeWays {

//	HashMap<String, Integer> m_ways = new HashMap<String, Integer>(); 
//	
//	//�ݹ鷨
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
//		//Java�е�substring������beginIndex ��endIndex��
//		//���أ���beginIndexλ�õ�endIndexλ���ڵ��ַ���(�������һ����ȡ���ַ���ԭ���е�������endIndex-1)
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
//		int w1 = 1 ;	//�൱��dp[i-1],������ʱ����
//		int w2 = 1;		//�൱��dp[i-2]����������
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
//			w2 = w1 ;//��������
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
		
		int w1 = 1;//w1�൱��dp[i-1]
		int w2 = 1;//w2�൱��dp[i-2] ������Ϊ��������������С�ռ临�Ӷ�
		for ( int i = 1 ; i < s.length() ; i ++ ){
			int w = 0 ;
			if( isValid(s.charAt(i))){
				w = w1 ;
			}
			if( isValid(s.charAt(i-1) , s.charAt(i))){
				w += w2 ;
			}
			w2 = w1;//����ȸ�ֵ��w2����ִ�У�w1 = w , w2 = w1��,��w1��ֵ�Ѿ�����,w2�������ϵ�w1��Ϊ�µ�dp[i-2]
			w1 = w;//��˱���������
		}
		return w1;
	}
}
