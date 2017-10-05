package practiceEasy;

public class HappyNumber {

	/*
	 * Assumptions:
	 * if n == 0; return false;
	 * 
	 * Steps: get the every digit from n use n % 10, and square it and add them together.
	 * 		  save the new number to n until n == 1.
	 * 
	 * Return true if n == 1, otherwise return false;
	 */
	public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
