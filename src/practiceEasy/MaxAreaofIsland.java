package practiceEasy;

public class MaxAreaofIsland {
	/*
	 * if grid is null or empty, return 0;
	 * 
	 * Steps: use dfs to explore each elment and its neigbhours.
	 * 
	 * Time: o(n * m)
	 */
	public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
        	return 0;
        }
        int area = 0;
        for(int i = 0; i < grid.length; i++){
        	for(int j = 0; j < grid[0].length; j++){
        		if(grid[i][j] == 1){
        			area = Math.max(area, countArea(grid, i, j));
        		}
        	}
        }
        return area;
    }
	
	private int countArea(int[][] grid, int r, int c){
		if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || 
				grid[r][c] == 0){
			return 0;
		}
		grid[r][c] = 0;
		return 1 + countArea(grid, r + 1, c) + countArea(grid, r - 1, c)
				+ countArea(grid, r, c + 1) + countArea(grid, r, c - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
