package practiceEasy;


import java.util.*;
public class ValidParentheses {
	/*
	 * Assumptions:
	 * if string is null or empty, then that count as valid.
	 * 
	 * Steps: Iterate each char of string, if encounter any (, { [, store it to stack.
	 * 		  if encounter any ), }, ] and the peek of stack if equal to the left side of 
	 * 	      any of them. then a valid pair is found, pop the top of the stack. if the whole
	 * 	      string is a valid Parentheses , then finally stack will remain empty.
	 * 
	 * Return true if stack is empty. return false otherwise.
	 * Time complexity: o(n) Space: o(n)
	 */
	public static boolean isValid(String s) {
		if(s == null || s.length() == 0){
			return true;
		}
		Deque<Character> stack = new LinkedList<> ();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
				stack.push(s.charAt(i));
			} else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '('){
				stack.pop();
			} else if(s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{'){
				stack.pop();
			} else if(s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '['){
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
