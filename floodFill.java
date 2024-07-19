class Solution {
    // Directions array for the 4-connected neighbors (left, down, right, up)
    int[][] dirs;

    // Depth-first search (DFS) helper method
    private void dfs(int[][] image, int currentRow, int currentCol, int color, int startColor) {
        // Check if the current cell is out of bounds or does not have the start color
        if (currentRow < 0 || currentRow >= image.length || currentCol < 0 || currentCol >= image[0].length
                || image[currentRow][currentCol] != startColor) {
            return;
        }

        // Change the color of the current cell to the target color
        image[currentRow][currentCol] = color;

        // Explore all four possible directions
        for (int[] dir : dirs) {
            dfs(image, currentRow + dir[0], currentCol + dir[1], color, startColor);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // If the starting pixel is already the target color, no changes are needed
        if (image[sr][sc] == color) return image;

        // Initialize the directions for movement (left, down, right, up)
        this.dirs = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

        // Start the DFS from the starting pixel
        dfs(image, sr, sc, color, image[sr][sc]);

        // Return the modified image
        return image;
    }
}
