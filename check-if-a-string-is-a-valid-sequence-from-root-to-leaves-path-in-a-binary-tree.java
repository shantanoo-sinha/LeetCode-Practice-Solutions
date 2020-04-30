/*

Reference: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/

Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree

Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree. 

We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.

 

Example 1:

         0
      /     \
     1       0
   /   \    /
  0     1  0
   \   / \
    1 0   0  

Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
Output: true
Explanation: 
The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
Other valid sequences are: 
0 -> 1 -> 1 -> 0 
0 -> 0 -> 0


Example 2:

         0
      /     \
     1       0
   /   \    /
  0     1  0
   \   / \
    1 0   0  

Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
Output: false 
Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.


Example 3:

         0
      /     \
     1       0
   /   \    /
  0     1  0
   \   / \
    1 0   0  

Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
Output: false
Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.


Constraints:
    1 <= arr.length <= 5000
    0 <= arr[i] <= 9
    Each node's value is between [0 - 9].

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return checkPath(root, arr, 0);
    }
    
    public static boolean checkPath(TreeNode root, int[] arr, int index) 
    { 
        // If root is NULL, then there must not be any element in array
        if(root==null || index==arr.length) {
            return false;
        }
        
        // If this node is a leaf and matches with last entry of array
        if((root.left==null && root.right==null) && (root.val==arr[index] && index==arr.length-1)) { 
            return true;
        }
        
        // If current node is equal to arr[index] this means
        // that till this level path has been matched and
        // remaining path can be either in left subtree or
        // right subtree.
        return (root.val==arr[index] && (checkPath(root.left,arr,index+1) || checkPath(root.right, arr, index+1)));
    } 
}
