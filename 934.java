import java.util.*;

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        // Step 1: Find the first island and mark it using DFS
        for (int i = 0; i < n; i++) {
            if (found)
                break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                    break;
                }
            }
        }

        // Step 2: Use BFS to expand the first island and find the shortest path to the
        // second island
        int steps = 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : directions) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        if (grid[x][y] == 1) {
                            return steps;
                        }
                        if (grid[x][y] == 0) {
                            grid[x][y] = -1; // Mark the water as visited
                            queue.offer(new int[] { x, y });
                        }
                    }
                }
            }
            steps++;
        }

        return -1; // Should never reach here if the input is valid
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = -1; // Mark the land as visited
        queue.offer(new int[] { i, j });
        dfs(grid, i + 1, j, queue);
        dfs(grid, i - 1, j, queue);
        dfs(grid, i, j + 1, queue);
        dfs(grid, i, j - 1, queue);
    }

    public static void main(String[] args) {
        ShortestBridge sb = new ShortestBridge();
        int[][] grid = {
                { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 0, 1 }
        };
        System.out.println(sb.shortestBridge(grid)); // Output: 2
    }
}
