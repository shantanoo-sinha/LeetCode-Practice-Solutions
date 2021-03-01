/*

Ref: https://leetcode.com/problems/word-search/

79. Word Search

Given an m x n board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:
    m == board.length
    n = board[i].length
    1 <= m, n <= 200
    1 <= word.length <= 103
    board and word consists only of lowercase and uppercase English letters.

*/
//DFS
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(word.charAt(0) == board[i][j] && search(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, int start, int row, int col) {
        if(start >= word.length())
            return true;
        
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length)
            return false;
        
        if(board[row][col] == '0' || board[row][col] != word.charAt(start))
            return false;
        
        char temp = board[row][col];
        board[row][col] = '0';
        if(search(board, word, start+1, row-1, col)
          || search(board, word, start+1, row+1, col)
          || search(board, word, start+1, row, col-1)
          || search(board, word, start+1, row, col+1))
            return true;
        board[row][col] = temp;
        
        return false;
    }
}
