/*

Reference: https://leetcode.com/problems/degree-of-an-array/

697. Degree of an Array

Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.

Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6

Note:
nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.

*/
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(left.containsKey(nums[i])) {
                right.put(nums[i], i);
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                left.put(nums[i], i);
                right.put(nums[i], i);
                count.put(nums[i], 1);
            }
        }
        int maxFrequency = Collections.max(count.values());
        int degree = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if(entry.getValue() == maxFrequency)
                degree = Math.min(degree, right.get(entry.getKey()) - left.get(entry.getKey()) + 1);
        }
        return degree;
    }
}
