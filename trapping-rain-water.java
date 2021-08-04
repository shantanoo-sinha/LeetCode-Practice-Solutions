/*

Reference: https://leetcode.com/problems/trapping-rain-water/

42. Trapping Rain Water - Hard

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.


Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:
    n == height.length
    0 <= n <= 2 * 10^4
    0 <= height[i] <= 10^5

*/
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3)
            return 0;
        
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        
        int[] rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        
        int output = 0;
        for(int i=0; i<height.length; i++) {
            output += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return output;
    }
}

// Approach 2
// Dynamic Programming with single iteration - Two Pointer approach
// Time Complexity - O(n) with Single Iteration
// Space Complexity - O(1)
class Solution {
    public int trap(int[] height) {
        int total = 0, leftMax = 0, rightMax = 0;
        int left = 0, right = height.length-1;
        while(left < right) {
            if(height[left] < height[right]) {
                // iterate from left
                leftMax = Math.max(leftMax, height[left]);
                total += leftMax - height[left++];
            } else {
                // iterate from right
                rightMax = Math.max(rightMax, height[right]);
                total += rightMax - height[right--];
            }
        }
        return total;
    }
}
