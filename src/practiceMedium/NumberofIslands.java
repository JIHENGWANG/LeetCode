package practiceMedium;

public class NumberofIslands {
	/*
	 * if grid is null or empty, then return 0;
	 * Use dfs to explore all 1's, and make it as '0'.
	 */
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
        	return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int islands = 0;
        for(int i = 0; i < r; i++){
        	for(int j = 0; j < c; j++){
        		if(grid[i][j] == '1'){
        			islands++;
        			dfs(grid, i, j);
        		}
        	}
        }
        return islands;
    }
	private void dfs(char[][] grid, int r, int c){
		if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
			return;
		}
		grid[r][c] = '0';
		dfs(grid, r - 1, c);
		dfs(grid, r + 1, c);
		dfs(grid, r, c - 1);
		dfs(grid, r, c + 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
