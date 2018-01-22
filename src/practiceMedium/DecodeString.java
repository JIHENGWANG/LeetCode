package practiceMedium;

public class DecodeString {
	/*
	 * if s is null or empty, return s itself.
	 * 
	 * Steps: recursively decode each character of string, if a current
	 * 		  character is a digit, and next character is not null, we
	 * 		  add next character amount of digit times, and go to next level
	 * 
	 * return a string
	 * 
	 * Time: o(StringBuilder) Space: o(string.length())
	 */
	private int pos;
	public String decodeString(String s) {
        if(s == null || s.length() == 0){
        	return s;
        }
       StringBuilder sol = new StringBuilder ();
       String number = "";
       for(int i = pos; i < s.length(); i++){
    	   char c = s.charAt(i);
    	   if(c != '[' && c != ']' && !Character.isDigit(c)){
    		   sol.append(c);
    	   } else if(Character.isDigit(c)){
    			   number += c;
    	   } else if (c == '[') {
    		   pos = i + 1;
    		   String add = decodeString(s);
    		   int length = Integer.parseInt(number);
    		   for(int j = 0; j < length; j++){
    			   sol.append(add);
    		   }
    		   number = "";
               i = pos;
    	   } else if(c == ']'){
               pos = i;
               return sol.toString();
           }
       }
       return sol.toString();
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
