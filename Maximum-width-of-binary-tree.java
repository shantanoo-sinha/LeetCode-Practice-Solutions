/*

Reference: https://leetcode.com/problems/maximum-width-of-binary-tree/

662. Maximum Width of Binary Tree
Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).


Example 2:
Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).


Example 3:
Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).


Example 4:
Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.

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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        int currentLevel = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        Queue<Integer> qlevel = new LinkedList<Integer>();
        qlevel.add(0);
        Map<TreeNode, Integer> position = new HashMap<>();
        position.put(root, 1);
        
        TreeNode start = root, end = root;
        int maxWidth = 1;
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = qlevel.poll();
            
            if(level>currentLevel) {
                start = node;
                currentLevel = level;
            }
                
            if(node.left!=null) {
                queue.add(node.left);
                qlevel.add(level+1);
                position.put(node.left, 2*position.get(node));
            }
            if(node.right!=null) {
                queue.add(node.right);
                qlevel.add(level+1);
                position.put(node.right, ((2*position.get(node))+1));
            }
            end = node;
            int width = position.get(end) - position.get(start) + 1;
            if(width > maxWidth){
                maxWidth = width;
            }
        }
        return maxWidth;
    }
}
