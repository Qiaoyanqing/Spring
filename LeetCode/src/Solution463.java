/**
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 */
public class Solution463 {

    public static void main(String[] args) {
//        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid = {{1}};
        Solution463 solution463 = new Solution463();
        System.out.println(solution463.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int x = grid.length, y = grid[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 1) {
                    //判断周围是否有相邻格子
                    result += check(grid, i, j);
                }
            }
        }
        return result;
    }

    public int check(int[][] grid, int x, int y) {
        int result = 4;
        int rowLength = grid.length - 1, columLength = grid[0].length - 1;
        int[] left = {-1,0};
        int[] right = {1, 0};
        int[] up = {0,-1};
        int[] down = {0,1};
        int[][] s = {null, null, null, null};
        //最左边的不往左移（-1， 0），最上边的不往上移（0，1）
        if (x != 0) {
            s[0] = left;
        }
        if (x != rowLength) {
            s[2] = right;
        }
        if (y != 0) {
            s[1] = up;
        }
        if (y != columLength) {
            s[3] = down;
        }
        for(int[] c : s) {
            if (c != null) {
                int newX = x + c[0];
                int newY = y + c[1];
                if (grid[newX][newY] == 1) {
                    result -= 1;
                }
            }
        }
        return result;
    }
}
