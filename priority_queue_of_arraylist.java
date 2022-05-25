class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        PriorityQueue<ArrayList<Integer>>pq = new PriorityQueue<ArrayList<Integer>>(new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer>a , ArrayList<Integer>b) {
                if(a.get(0) < b.get(0)){
                    return -1 ; // do not swap 
                } else if(a.get(0) > b.get(0)){
                    return 1 ; // swap the values 
                }
                return 0 ; // do not change anything 
                //swap in asscending order  1
                // mo change -1,0
                
            }
        }) ;
        int n = heights.length ;
        int m = heights[0].length ;
        ArrayList<Integer> temp = new ArrayList<Integer>() ;
        temp.add(0) ;
        temp.add(0) ;
        temp.add(0) ;
        int ans = 0 ;
        pq.add(temp) ;
        int[][] visited = new int[n][m] ;
        for(int[] it : visited ){
            Arrays.fill(it,-1) ;
        }
        int[] row = new int[]{-1,0,1,0} ;
        int[] col = new int[]{0,1,0,-1} ;
        //System.out.println(pq.peek().get(0));
        while(pq.size()>0){
            ArrayList<Integer>giga = pq.poll() ;
            int dist = giga.get(0) ;
            int x = giga.get(1) ;
            int y = giga.get(2) ;
            int yandu = heights[x][y] ;
            //System.out.println(dist+" "+x+" "+y) ;
            visited[x][y] = 1 ;
            ans = Math.max(dist,ans) ;
            if(x==n-1 && y==m-1) {
                return ans ;
            }
            //System.out.println("Hello ");
            
            for( int i =0 ; i < 4 ; i+=1 ) {
                int newx = x + row[i] ;
                int newy = y + col[i] ;
                // if(x==0 && y==1 ) {
                //     System.out.println(newx+" "+newy);
                // }
                if(newx >=0 && newy>=0 && newx < n && newy<m  && visited[newx][newy] == -1 ) {
                    int temp_diff = Math.abs(yandu-heights[newx][newy]) ;
                    ArrayList<Integer> temp1 = new ArrayList<Integer>() ;
                    temp1.add(temp_diff) ;
                    temp1.add(newx) ;
                    temp1.add(newy) ;
                    //System.out.println(temp_diff+" "+newx+" "+newy) ;
                    pq.add(temp1) ;
                }
            }
            //System.out.println("Hii ");
            
        }
        // System.out.println("Koka") ;
        return ans ;
    }
}
