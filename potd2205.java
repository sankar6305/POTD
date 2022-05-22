class Solution {
	    public Boolean isPalindrome(String temp) {
		            int left =0 ;
			            int right = temp.length()-1 ;
				            while(left < right ) {
						                if(temp.charAt(left) != temp.charAt(right)) {
									                return false ;
											            }
								            left++;
									                right-- ;
											        }
					            return true ;
						        }
	        public int countSubstrings(String S) {
			        HashMap<String,Integer>mp = new HashMap<>() ;
				        int count= 0 ;
					        
					        for(int i =0 ; i < S.length() ; i++ ) {
							            for( int j =i+1 ; j <= S.length() ; j++ ) {
									                    String temp = S.substring(i,j) ;
											                    if(isPalindrome(temp)) {
														                        count++;
																	                }
													                }
								                
								            }
						        return count ;
							    }
}
