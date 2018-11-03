package Dynamic_Programming;

public class leetcode53_MaximumSubarray {

	public int maxSubarray( int [] nums){
		
		/*
		 * nums = [-2,1,-3,4,-1,2,1,-5,4]
		 * f:	  [-2,1,-2,4, 3,5,6,1 ,5]
		 * f[i] 记录下 以nums[i]为结尾的所能得到的最大自序列的和,即：maxSubarrau[0..i]
		 * 状态转移方程:
		 * f[i] = f[i-1] >0 ? nums[i]+f[i-1]:nums[i]
		 * 
		 * */
//		int []f = new int[nums.length];
//		f[0] = nums[0] ;
//		int max0 = f[0];//记录最大子序列和
//		for ( int i = 1 ; i < nums.length ; i ++ ){
//			f[i] = Math.max(nums[i]+f[i-1], nums[i]);
//			if ( f[i] > max0 ){
//				max0 = f[i];
//			}
//		}
//		return max0;
//		优化版本如下：
		int ans = nums[0];
		int sum = nums[0];//表示当前的f[i]（以nums[i]为结尾的最大和）
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
