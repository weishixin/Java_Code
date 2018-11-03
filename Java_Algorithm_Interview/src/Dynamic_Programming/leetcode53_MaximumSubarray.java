package Dynamic_Programming;

public class leetcode53_MaximumSubarray {

	public int maxSubarray( int [] nums){
		
		/*
		 * nums = [-2,1,-3,4,-1,2,1,-5,4]
		 * f:	  [-2,1,-2,4, 3,5,6,1 ,5]
		 * f[i] ��¼�� ��nums[i]Ϊ��β�����ܵõ�����������еĺ�,����maxSubarrau[0..i]
		 * ״̬ת�Ʒ���:
		 * f[i] = f[i-1] >0 ? nums[i]+f[i-1]:nums[i]
		 * 
		 * */
//		int []f = new int[nums.length];
//		f[0] = nums[0] ;
//		int max0 = f[0];//��¼��������к�
//		for ( int i = 1 ; i < nums.length ; i ++ ){
//			f[i] = Math.max(nums[i]+f[i-1], nums[i]);
//			if ( f[i] > max0 ){
//				max0 = f[i];
//			}
//		}
//		return max0;
//		�Ż��汾���£�
		int ans = nums[0];
		int sum = nums[0];//��ʾ��ǰ��f[i]����nums[i]Ϊ��β�����ͣ�
		for ( int i = 1 ; i < nums.length ; i ++ ){
			sum = Math.max(sum +nums[i], nums[i]);
			if ( sum > ans ){
				ans = sum ;
			}
		}
		return ans ;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leetcode53_MaximumSubarray l1 = new leetcode53_MaximumSubarray();
		int []a = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(l1.maxSubarray(a));
	}

}
