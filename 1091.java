import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        

        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows-1][cols-1] == 1){
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        queue.add(new int[]{0,0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            
            int size = queue.size();

            for (int i = 0; i < size; i++){
                int[] cell = queue.poll();

                if( cell[0] == rows-1 && cell[1] == cols - 1){
                    return cell[2]+1;
                }

                for( int[] direction: directions){
                    int newRow = direction[0] + cell[0];
                    int newCol = direction[1] + cell[1];

                    if( newRow>=0 && newRow < rows && newCol >=0 && newCol < cols &&  grid[newRow][newCol] == 0 && visited[newRow][newCol] == false  ){
                        queue.add(new int[]{newRow,newCol,cell[2]+1});
                        visited[newRow][newCol] = true;
                    } 
                }

            }
        }
        return -1;
        
    }
}