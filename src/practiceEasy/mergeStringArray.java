package practiceEasy;

public class mergeStringArray {
	public static String merge(String[] array){
		if(array == null || array.length == 0){
			return "";
		}
		int[] count = new int[26];
		StringBuilder sol = new StringBuilder();
		for(String str : array){
			for(int i = 0; i < str.length(); i++){
				if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
					int index = str.charAt(i) - 'a';
					count[index]++;
				}
			}
		}
		for(int i = 0; i < count.length; i++){
			for(int j = 0; j < count[i]; j++){
				sol.append((char)('a' + i));
			}
		}
		return sol.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = {"alhdfa;", "asljlawe", "asdfasira", "asudhf29384lasda"};
		String sol = merge(array);
		System.out.print(sol);

	}

}
