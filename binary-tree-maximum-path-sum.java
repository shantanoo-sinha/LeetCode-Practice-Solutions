/*

Reference: https://leetcode.com/problems/binary-tree-maximum-path-sum/

124. Binary Tree Maximum Path Sum

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return globalMax;
    }
    
    private int maxSum(TreeNode node) {
        if(node == null)
            return 0;
        
        int left = maxSum(node.left);
        int right = maxSum(node.right);
        
        int max = Math.max(left, right);
        max = Math.max(max+node.val, node.val);
        globalMax = Math.max(globalMax, Math.max(max, left+node.val+right));
        
        return max;
    }
}
