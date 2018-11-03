package Dynamic_Programming;



public class Fibonacii {
	/*public static int Fibnacci( int n ){
		if ( n <= 0 ){
			return n;
		}
		int []Memo = new int[n+1];
		for ( int i = 0 ; i <= n ; i ++ ){
			Memo[i] = -1;
		}
		return fib( n ,Memo);
	}
	public static int fib ( int n , int []Memo ){
		if( Memo[n] != -1){
			return Memo[n];
		}
		if( n <= 2 ){
			Memo[n] = 1 ;
		}else{
			Memo[n] = fib(n-1, Memo) + fib(n-2, Memo);
		}
		return Memo[n];
	}*/
	
	public static int fib ( int n ){
		if( n < 0 ){
			return n;
		}
		int []Memo = new int[n+1];
		Memo[0]=Memo[1] = 1;
		for ( int i = 2 ; i<= n ; i ++){
			Memo[i] = Memo[i-1]+Memo[i-2];
		}
		return Memo[n];
	}
	
	
	public static void main(String[] args) {
		System.out.println(fib(6));
	}
}
