package WeekCopetition;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

public class danDiao_Array {

	public boolean isMonotonic(int[] A) {
		boolean ans =true , flag= true ;
		int k = 0;
		if ( A.length == 1){
			return ans;
		}
        int []a1 = new int[A.length-1];
        for ( int i = 0 ; i < a1.length; i++){
        	a1[i] = A[i+1]-A[i];
        	if( a1[i]<0 && k !=1){
        		k =1 ;
        	}
        	if( a1[i]>0 && k!=2){
        		k = 2;
        	}
        	if( a1[i]>0 && k == 1){
        		return false;
        	}
        	if( a1[i]<0 && k== 2){
        		return false;
        	}
        }
        
//        for ( int j = 0; j<a1.length ; j++){
//        	if ( flag == true){
//        		if( a1[j]>=0){
//        			continue;
//        		}else {
//					ans = false;
//					break;
//				}
//        	}else {
//        		if( a1[j]<=0){
//        			continue;
//        		}else {
//					ans = false;
//					break;
//				}
//			}
//        }
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A={1,1,0};
		danDiao_Array d = new danDiao_Array();
		System.out.println(d.isMonotonic(A));
	}

}
