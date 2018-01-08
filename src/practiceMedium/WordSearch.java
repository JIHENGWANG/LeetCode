package practiceMedium;

public class WordSearch {
	
	/*
	 * if word or board is null or empty, then return false;
	 * Steps: Use DFS to find the path on board that represent the word.
	 * Time Complexity: o(nm*4^l)
	 */
	public static boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0 || board == null || board.length == 0){
        	return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board[0].length; j++){
        		if(word.charAt(0) == board[i][j] && findWord(board, visited, word, 0, i, j)){
        			return true;
        		}
        	}
        }
        return false;
    }
	private static boolean findWord(char[][] board, boolean[][] visited, String word, 
			int pos, int row, int col){
		if(pos == word.length()){
			return true;
		}
		if(row < 0 || col < 0 || row >= board.length || col >= board[0].length 
				|| board[row][col] != word.charAt(pos) || visited[row][col]){
			return false;
		}
		visited[row][col] = true;
		if(findWord(board, visited, word, pos + 1, row + 1, col) ||
		   findWord(board, visited, word, pos + 1, row - 1, col) ||
		   findWord(board, visited, word, pos + 1, row, col + 1) ||
		   findWord(board, visited, word, pos + 1, row, col - 1)
		   ){
			return true;
		}
		visited[row][col] = false;
		return false;
	}
	/*
	 * findWord(board, visited, word, pos + 1, row - 1, col - 1) ||
	   findWord(board, visited, word, pos + 1, row + 1, col + 1) ||
	   findWord(board, visited, word, pos + 1, row + 1, col - 1) ||
	   findWord(board, visited, word, pos + 1, row - 1, col + 1)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A','B','C','E'},
						  {'S','F','C','S'},
						  {'A','D','E','E'}};
		System.out.print(exist(board, "ABCCED"));
	}

}
