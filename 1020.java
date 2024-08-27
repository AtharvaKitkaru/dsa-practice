class Solution {
    public int numEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && (i == 0 || j == 0 || i == rows - 1 || j == cols - 1)) {
                    dfs(grid, i, j, visited);
                }
            }
        }

        int noOfEnclaves = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    noOfEnclaves++;
                }
            }
        }

        return noOfEnclaves;

    }

    void dfs(int[][] grid, int row, int col, int[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] == 1
                || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;
        // System.out.printf("Row: %d, Col: %d \n", row,col);
        visited[row][col] = 1;

        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row, col + 1, visited);
    }
}