/*

Reference: https://leetcode.com/problems/island-perimeter/

463. Island Perimeter

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.


Example:
Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:

*/
class Solution {
    
    public int islandPerimeter(int[][] grid) {
        int island = 0, neighbor = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j]==1) {
                    //count number of islands i.e. 1
                    island++;
                    
                    //count the neighbor i.e. if right or down is 1
                    if(j<grid[i].length-1 && grid[i][j+1]==1)
                        neighbor++;
                    if(i<grid.length-1 && grid[i+1][j]==1)
                        neighbor++;
                }
            }
            // System.out.println("island:" + island + ", neighbor:" + neighbor);
        }       
        return (island*4) - (neighbor*2);
    }
}
