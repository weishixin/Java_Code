package Dynamic_Programming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leetcode403_frogjump {

    public boolean canCross( int [] stones){
        int k = 0 ;
        return helper( stones , 0 , k );
    }

    private boolean helper( int []stones , int index , int k ){
        //目前已经达到了
        if ( index == stones.length - 1){
            return true;
        }
        for ( int i = k-1 ; i <= k +1 ; i ++ ){
            int nextJump = stones[index] + i ;
            //看接下来有没有合适的石头可以跳过去，从接下来的位置中查找有没有nextJump的位置，有的话返回石头的编号
            int nextPosition = Arrays.binarySearch(stones , index+1 , stones.length , nextJump);
            if ( nextPosition > 0 ){
                if( helper(stones , nextPosition , i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(){
        int []path = {0,1,3,5,6,8,12,17};
        leetcode403_frogjump a = new leetcode403_frogjump();
        System.out.print(a.canCross(path));
    }

}
