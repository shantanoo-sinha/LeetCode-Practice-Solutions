/*

Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

Reference: https://leetcode.com/problems/binary-tree-right-side-view/

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
    int currentLevel = -1;
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        
        if(root == null)
            return list;
        
        //list.add(root.val);
        traverse(root, list, 0);
        
        return list;
    }
    
    public void traverse(TreeNode node, List<Integer> list, int level) {
        if(node == null)
            return;
        
        if(level > currentLevel) {
            list.add(node.val);
            currentLevel = level;
        }
            
        if(node.right != null)
            traverse(node.right, list, level+1);
        
        if(node.left != null)
            traverse(node.left, list, level+1);
    }
}
