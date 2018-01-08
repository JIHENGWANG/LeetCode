package practiceMedium;

public class printDiagonal {
	public static void diagonal(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;

		}
		int r = 0, c = 0;
		for (int i = 0; i < matrix.length * matrix[0].length; i++) {
			System.out.print(matrix[r][c] + " ");
			if ((r + c) % 2 == 0) {
				if (r == matrix.length - 1) {
					c++;
				} else if (c == 0) {
					r++;
				} else {
					r++;
					c--;
				}
			} else {
				if (c == matrix[0].length - 1) {
					r++;
				} else if (r == 0) {
					c++;
				} else {
					r--;
					c++;
				}
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, };

		diagonal(matrix);
		// Should output 1 4 2 3 5 7 8 6 9
	}

}
