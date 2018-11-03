package Dynamic_Programming;

public class leetcode375_GusessNumberHigherOrLower2 {

	public int getMoneyAmount(int n) {
		
		if ( n <= 2 ){
			return n-1;
		}
		//dp���� ���ϱ�ʾ��i��j֮��Ĳ�������һ������ ����Ҫ����С����
		int [][] dp = new int[n+1][n+1];
		for( int i = 0 ; i < n+1 ; i ++){//��ʼ��
			for( int j = 0 ; j < n+1 ; j ++){
				dp[i][j] = 0;
			}
		}
		
		for ( int i = 2 ; i <= n ; i ++){
			for ( int j = i - 1 ; j > 0 ; j -- ){//�����j��i��˳�� ���Ա�֤����ʱ���Ӽ����Ѿ������
				int global = Integer.MAX_VALUE ;
				int local = 0 ;
				//������� j�� i֮�� ��һ��ֵk, Ȼ��Ƚ�j��k-1�� k+1��i֮���dpֵ����ѡ�����ߵ����ֵ������Ϊ��cover����
				//���￼�������������������һ������Ҫ�µ�ֵ����k����
				for( int k = j+1 ; k < i ; k ++){
					local = Math.max(dp[j][k-1], dp[k+1][i]) + k ;//����ֲ���󻨷�
					global = Math.min( global , local);//�����Ƚϣ��õ�i��j�ϵ��ܲ³��������ֵ� ��С���ۣ�Ǯ��
				}
				dp[j][i] = j+1 == i ? j:global;//ע�����j��i���ڣ�ֱ�ӵó�j������ó�global
			}
		}
        return dp[1][n];
    }
	
	//���õĽ��
//	public int getMoneyAmount(int n) {
//        int[][] dp = new int[n+1][n+1];
//        return needMoneyMustWin(1,n,dp);
//    }
//    public int needMoneyMustWin(int from,int to,int dp[][]){
//        if(from >= to){
//            return 0;
//        }
//        if(from >= to-2){  //��: [1,2] [1,2,3]
//            return to-1;
//        }
//        if(dp[from][to] != 0){
//            return dp[from][to];
//        }
//        int min = Integer.MAX_VALUE;
//        //��[from,to]������ ��Ҫ����Ǯ ��֤Ӯ? ֻҪ����ѡ������������ϰ�����[from-to���м俪ʼ , to] �������������������������
//        for(int i = (from+to)/2-1; i <= to; i++){
//            int left = needMoneyMustWin(from,i-1,dp);
//            int right = needMoneyMustWin(i+1,to,dp);
//            int max = i + Math.max(0 , Math.max(left,right));
//            min = Math.min(max,min);
//        }
//        dp[from][to] = min;
//        return dp[from][to];
//    }
}
