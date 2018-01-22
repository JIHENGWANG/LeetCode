package practiceEasy;

public class MajorityElement {
	/*
	 * way of fighting. 打擂台的方式去删减元素
	 * 
	 * Time： o(n), o(1)
	 */
	public int majorityElement(int[] nums) {
	       int count = 0;
	        Integer candidate = null;

	        for (int num : nums) {
	            if (count == 0) {
	                candidate = num;
	            }
	            count += (num == candidate) ? 1 : -1;
	        }

	        return candidate;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
