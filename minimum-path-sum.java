/*

Reference: https://leetcode.com/problems/minimum-path-sum/

64. Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/
class Solution {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        return min(grid, height - 1, width - 1);		
    }
		
    public static int min(int[][]grid, int row, int col){
        if(row == 0 && col == 0) return grid[row][col]; // this is the exit of the recursion
        if(row == 0) return grid[row][col] + min(grid, row, col - 1); /** when we reach the first row, we could only move horizontally.*/
        if(col == 0) return grid[row][col] + min(grid, row - 1, col); /** when we reach the first column, we could only move vertically.*/
        return grid[row][col] + Math.min(min(grid, row - 1, col), min(grid, row, col - 1)); /** we want the min sum path so we pick the cell with the less value */
	}
}
