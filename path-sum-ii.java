/*

Reference: https://leetcode.com/problems/path-sum-ii

113. Path Sum II

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
A leaf is a node with no children.

Example 1:
                   5
                 /   \
                4     8
               /    /   \
             11    13    4
            /  \        / \
           7    2      5   1
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]

Example 2:
                  1
                 / \
                2   3
Input: root = [1,2,3], targetSum = 5
Output: []

Example 3:
Input: root = [1,2], targetSum = 0
Output: []

Constraints:
    The number of nodes in the tree is in the range [0, 5000].
    -1000 <= Node.val <= 1000
    -1000 <= targetSum <= 1000
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
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return paths;
        iterate(root, new ArrayList<Integer>(), targetSum);
        return paths;
    }
    public void iterate(TreeNode node, List<Integer> path, int targetSum) {
        if(node == null)
            return;

        path.add(node.val);
        
        if(node.left == null && node.right == null && targetSum - node.val == 0) {
            paths.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        } else {
            iterate(node.left, path, targetSum-node.val);
            iterate(node.right, path, targetSum-node.val);
        }
        
        if(!path.isEmpty())
            path.remove(path.size()-1);
    }
}
