// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        Queue<ArrayList<Integer>>Q = new LinkedList<>() ;
        
        int n= grid.length ;
        int m = grid[0].length ;
        for( int i =0 ; i < n ; i++ ) {
            for( int j =0;  j < m ; j++ ) {
                if(grid[i][j] == 2 ) {
                    ArrayList<Integer>temp = new ArrayList<>() ;
                    temp.add(0);
                    temp.add(i) ;
                    temp.add(j) ;
                    Q.add(temp) ;
                    grid[i][j]= 0 ;
                }
            }
        }
        int[] row = {0,0,1,-1} ;
        int[] col = {1,-1,0,0} ;
        int ans =0 ;
        while(Q.size() > 0 ) {
            ArrayList<Integer>temp = Q.poll() ;
            int count = temp.get(0) ;
            int x = temp.get(1) ;
            int y = temp.get(2) ;
            ans= Math.max(count,ans) ;
            for( int i =0 ; i < 4 ; i++ ) {
                int newx = x + row[i] ;
                int newy = y + col[i] ;
                if( newx>=0 && newy>=0 && newx < n && newy < m && grid[newx][newy] == 1) {
                    ArrayList<Integer>temp1 = new ArrayList<>() ;
                    temp1.add(count+1);
                    temp1.add(newx) ;
                    temp1.add(newy) ;
                    Q.add(temp1) ;
                    grid[newx][newy]= 0 ;
                }
            }
        }
        for( int i =0 ; i < n ; i++ ) {
            for( int j =0 ; j < m ; j++ ) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans ;
        // Code here
    }
}



