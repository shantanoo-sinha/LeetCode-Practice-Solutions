/*

Reference: https://leetcode.com/problems/sum-root-to-leaf-numbers/

129. Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example 1:
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

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
// Recursive
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return sum;
        traverse(root, root.val);
        return sum;
    }
    
    private void traverse(TreeNode node, int num) {
        if(node.left == null && node.right == null){
            sum += num;
            return;
        }
        if(node.left != null)
            traverse(node.left, (num*10)+node.left.val);
        if(node.right != null)
            traverse(node.right, (num*10)+node.right.val);
    }
}

// Iterative
class Solution {
    
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        
        if(root == null)
            return sum;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if(node.left == null && node.right == null){
                sum += node.val;
                continue;
            }
            if(node.left != null) {
                node.left.val = (node.val*10)+node.left.val;
                stack.push(node.left);
            }
            if(node.right != null) {
                node.right.val = (node.val*10)+node.right.val;
                stack.push(node.right);
            }
        }
        return sum;
    }
}
