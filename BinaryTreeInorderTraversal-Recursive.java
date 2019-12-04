/**
Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]

Follow up: Recursive solution is trivial, could you do it iteratively?

Reference: https://leetcode.com/problems/binary-tree-inorder-traversal/
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        if(root == null)
            return list;
            
        traverseInOrder(root, list);
        
        return list;
    }
    
    public void traverseInOrder(TreeNode node, List<Integer> list) {
        if(node == null)
            return;
        
        if(node.left != null)
            traverseInOrder(node.left, list);
        
        list.add(node.val);
        
        if(node.right != null)
            traverseInOrder(node.right, list);
    }
}
