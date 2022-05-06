class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>>st = new Stack<Pair<Character,Integer>>() ;
        StringBuffer sb = new StringBuffer() ;
        for( int i =0 ; i < s.length() ; i++ ) {
            if(st.size() == 0 ) {
                Pair<Character,Integer>temp = new Pair<>(s.charAt(i),1) ;
                st.push(temp) ;
            } else if(st.peek().getKey() != s.charAt(i) ) {
                st.push(new Pair<Character,Integer>(s.charAt(i),1)) ;
            } else {
                Pair<Character,Integer>temp = st.peek() ;
                st.pop() ;
                int y = temp.getValue() + 1 ;
                if(y != k ) {
                    st.push(new Pair<Character,Integer>(s.charAt(i),y));
                }
            }
        }
        while(st.size()>0) {
            Character ch = st.peek().getKey() ;
            int times = st.peek().getValue() ;
            for( int i =0 ; i < times ; i++ ) {
                sb.append(ch) ;
            }
            st.pop() ;
        }
        sb.reverse() ;
        return sb.toString() ;
    }
}