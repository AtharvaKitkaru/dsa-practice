import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{entrance[0], entrance[1]});
        visited.add(entrance[0] + "," + entrance[1]); // Mark the entrance as visited

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // Check if new cell is within bounds and is an empty space
                    if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length && maze[newRow][newCol] == '.') {
                        // Check if the new cell is an exit (edge of the maze)
                        if (newRow == 0 || newRow == maze.length - 1 || newCol == 0 || newCol == maze[0].length - 1) {
                            // Make sure the exit is not the entrance
                            if (!(newRow == entrance[0] && newCol == entrance[1])) {
                                return steps;
                            }
                        }
                        
                        String newCell = newRow + "," + newCol;
                        if (!visited.contains(newCell)) {
                            queue.add(new int[]{newRow, newCol});
                            visited.add(newCell);
                        }
                    }
                }
            }
        }

        return -1; // No exit found
    }
}
