// http://leetcode.com/problems/flood-fill/
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
    };
    int sr = 1, sc = 1, newColor = 2;
    floodFill(image, sr, sc, newColor);
    for (int[] row : image) {
        for (int col : row) {
            System.out.print(col + " ");
        }
        System.out.println();
    }
}

public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int oldColor = image[sr][sc];
    if (oldColor != newColor) {
        dfs(image, sr, sc, oldColor, newColor);
    }
    return image;
}

private static void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
    if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
    if (image[r][c] != oldColor) return;

    image[r][c] = newColor;
    dfs(image, r + 1, c, oldColor, newColor);
    dfs(image, r - 1, c, oldColor, newColor);
    dfs(image, r, c + 1, oldColor, newColor);
    dfs(image, r, c - 1, oldColor, newColor);
}
}