/*

Reference: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.


Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1


Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

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
    int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = inOrder(root, k);
        return node.val;
    }
    
    public TreeNode inOrder(TreeNode node, int k) {
        if(node == null)
            return null;
        
        TreeNode left = inOrder(node.left, k);
        if(left != null)
            return left;
        
        count++;
        
        if(count == k)
            return node;
        
        return inOrder(node.right, k);
    }
}
