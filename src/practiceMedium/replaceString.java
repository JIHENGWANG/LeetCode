package practiceMedium;

import java.util.ArrayList;
import java.util.List;

public class replaceString {

	public static String replace(String input, String s, String t) {
		// Write your solution here.
		char[] array = input.toCharArray();
		char[] arrayS = s.toCharArray();
		char[] arrayT = t.toCharArray();
		if(s.length() >= t.length()){
			return simpleReplace(array, arrayS, arrayT);
		} else {
			return longReplace(array, arrayS, arrayT);
		}
	}

	private static String longReplace(char[] input, char[] s, char[] t){
		List<Integer> ocurrence = getAllMatches(input, s);
		int extra = ocurrence.size() * (t.length - s.length);
		char[] newInput = new char[input.length + extra];
		int slow, fast;
		slow = 0;
		fast = 0;
		int firstOcurrence = 0;
		while(fast < input.length){
			if(firstOcurrence < ocurrence.size() && fast == ocurrence.get(firstOcurrence)){		
				for(int i = 0; i < t.length; i++){
					newInput[slow++] = t[i];		
				}
				fast += s.length;
				firstOcurrence++;
			} else{
				newInput[slow++] = input[fast++];
			}
		}
		return new String(newInput);
	}

	private static boolean equalSubstring (char[] input, int fromIndex, char[] s){
		for(int i = 0; i < s.length; i++){
			if(input [fromIndex + i] != s[i]){
				return false;
			}
		}
		return true;
	}
	
	private static List<Integer> getAllMatches(char [] input, char[] s){
		List<Integer> matches = new ArrayList<Integer> ();
		int i = 0;
		while(i <= input.length - s.length){
			if(equalSubstring(input, i, s)){
				matches.add(i);
				i += s.length;
			} else {
				i++;
			}
			
		}
		return matches;
	}


  private static String simpleReplace(char[] input, char[] s, char[] t){
		int slow, fast;
		slow = fast = 0;
		while(fast < input.length){
			if(fast + s.length <= input.length && equalSubstring(input, fast, s)){
				for(int i = 0; i < t.length; i++){
					input[slow++] = t[i];
				}
				
				fast += s.length;
			} else {
				input[slow++] = input[fast++];
			}
		}
		return new String(input, 0, slow);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "safasdfa";
		System.out.print(test.substring(0,  4));
	}

}
