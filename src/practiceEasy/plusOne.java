package practiceEasy;

public class plusOne {
	/*
	 * Assumptions:
	 * If digits == null || digits.length == 0, then return null;
	 * 
	 * Steps: Iterative each element of digits from last one to first one
	 * 		  if digits[i] == 9; then digist[i] = 0;
	 * 		  if(digits[0] = 0), int[] result =  new int[digits.length + 1];
	 * 		  and result[0] = 1. return result. otherwise return digits.
	 * 
	 * return an array that is digits + 1.
	 * 
	 * Time: o(n), Spce: o(n)
	 */
	public static int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0){
			return new int[] {};
		}
		for(int i = digits.length - 1; i >= 0; i--){
			if(digits[i] != 9){
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int [] sol = new int[digits.length + 1];
		sol[0] = 1;
		return sol;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float sum = 0;
		float temp = 365;
		float tem2 = 366;
		for(int i = 1; i < 201; i++){
			sum += ((364/(tem2 - i)));
		}
		System.out.println(sum);

	}

}
