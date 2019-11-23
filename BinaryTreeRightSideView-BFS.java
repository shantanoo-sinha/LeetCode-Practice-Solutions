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
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        Queue<Integer> level = new LinkedList<>();
        level.add(0);
        
        traverse(queue, level, list);
        
        return list;
    }
    
    public void traverse(Queue<TreeNode> queue, Queue<Integer> level, List<Integer> list) {
        
        while(!queue.isEmpty()) {
            
            TreeNode node = queue.poll();
            int nodeLevel = level.poll();
        
            if(nodeLevel > currentLevel) {
                list.add(node.val);
                currentLevel = nodeLevel;
            }

            if(node.right != null) {
                queue.add(node.right);
                level.add(nodeLevel+1);
            }

            if(node.left != null) {
                queue.add(node.left);
                level.add(nodeLevel+1);
            }
        }
    }
}
