package GfG.Graphs;
/*
GfG problem - "Flood fill Algorithm" solution
Link : https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
 */

public class FoodFill {
    private void dfs(int[][] image, int x, int y, int rows, int cols, int newColor, int origColor) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || image[x][y] != origColor)
            return;

        image[x][y] = newColor;

        dfs(image, x + 1, y, rows, cols, newColor, origColor);
        dfs(image, x - 1, y, rows, cols, newColor, origColor);
        dfs(image, x, y + 1, rows, cols, newColor, origColor);
        dfs(image, x, y - 1, rows, cols, newColor, origColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;

        int rows = image.length, cols = image[0].length;
        dfs(image, sr, sc, rows, cols, newColor, image[sr][sc]);

        return image;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
