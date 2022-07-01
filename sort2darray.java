class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,new Comparator<int[]>(){ 
            public int compare(int[] a, int[] b){
                return Integer.compare(b[1],a[1]); // Descending order  {[
                // reeturn Integer.compare(a[1],b[1])
            }
            
        });
        int value= 0; 
        for(int i=0;i<boxTypes.length && truckSize!=0 ; i++){
            if(boxTypes[i][0]<=truckSize){
                truckSize-=boxTypes[i][0] ;
                value+= boxTypes[i][1]*boxTypes[i][0] ;
            }else{
                value+= truckSize*boxTypes[i][1];
                break;
            }
        }
        return value;
    }
}
