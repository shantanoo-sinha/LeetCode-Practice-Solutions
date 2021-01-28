/*

Reference: https://leetcode.com/problems/merge-two-binary-trees/

617. Merge Two Binary Trees

Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7

Note: The merging process must start from the root nodes of both trees.

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {t1, t2});
        while(!stack.isEmpty()) {
            TreeNode[] node = stack.pop();
            
            if(node[0] == null || node[1] == null)
                continue;
            
            node[0].val = node[0].val + node[1].val;
            if(node[0].left == null)
                node[0].left = node[1].left;
            else
                stack.push(new TreeNode[] {node[0].left, node[1].left});
            
            if(node[0].right == null)
                node[0].right = node[1].right;
            else
                stack.push(new TreeNode[] {node[0].right, node[1].right});
        }
        return t1;
    }
}
