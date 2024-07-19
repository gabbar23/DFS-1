import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> que = new LinkedList<>();
        
        // Initialize the matrix and queue
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 1) {
                    // Mark cells with 1 as -1 to indicate they have not been visited
                    mat[row][col] = -1;
                } else {
                    // Add all cells with 0 to the queue
                    que.add(new int[] { row, col });
                }
            }
        }

        // Directions array for the 4-connected neighbors (up, down, left, right)
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        
        // Initialize distance
        int dist = 0;
        
        // Perform BFS from all initial 0's
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                // Dequeue the front cell
                int[] cell = que.poll();
                for (int[] dir : dirs) {
                    // Calculate the new row and column indices
                    int currentRow = cell[0] + dir[0];
                    int currentCol = cell[1] + dir[1];
                    
                    // Check if the new cell is within bounds and has not been visited
                    if (currentRow >= 0 && currentRow < rows && currentCol >= 0 && currentCol < cols
                            && mat[currentRow][currentCol] == -1) {
                        // Update the cell with the new distance
                        mat[currentRow][currentCol] = dist + 1;
                        // Add the new cell to the queue
                        que.add(new int[] { currentRow, currentCol });
                    }
                }
            }
            // Increment the distance for the next layer
            dist++;
        }
        
        // Return the updated matrix
        return mat;
    }
}
