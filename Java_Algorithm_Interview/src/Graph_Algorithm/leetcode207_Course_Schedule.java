package Graph_Algorithm;

public class leetcode207_Course_Schedule {


    private int [][] graph_ ;
    private int n ;

    public boolean canFinish( int numCourses , int[][] prerequisites){
        n = numCourses;
        graph_ = new int[numCourses][numCourses];
        for( int i = 0 ; i < numCourses ; i ++ ){
            for ( int j = 0 ; j < numCourses ; j ++ ){
                graph_[i][j] = 0;
            }
        }
        int m = prerequisites.length;
        // int n = prerequisites[0].length;
        // System.out.println(m);
        for( int i = 0 ; i < m ; i ++ ){
            graph_[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        // for( int i = 0 ; i < numCourses ; i ++ ){
        //     for ( int j = 0 ; j < numCourses ; j ++ ){
        //         System.out.print(graph_[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        //states of v : 0 = unKnown , 1 = visiting , 2 = visited
        int [] v = new int[numCourses];
        for( int i = 0 ; i < numCourses ; i ++ ){
            v[i] = 0;
        }
        for ( int i = 0 ; i < numCourses ; i ++ ){
            if( dfs( i , v ))
                return false;
        }
        return true;
    }

    public boolean dfs( int cur , int [] v ){//深度搜索
        if ( v[cur] == 1 )
            return true;
        if ( v[cur] == 2 )
            return false;

        v[cur] = 1;
        for( int i = 0 ; i < n ; i ++ ){
            if( graph_[cur][i] != 0 ){
                if( dfs( i , v) )
                    return true;
            }
        }
        v[cur] = 2;
        return false;
    }
    public static void main( String []args){
        leetcode207_Course_Schedule a = new leetcode207_Course_Schedule();
        int [][] test = {{1,0}};

        System.out.print(a.canFinish(2,test));
    }
}
