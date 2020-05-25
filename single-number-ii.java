/*

Reference: https://leetcode.com/problems/single-number-ii/

137. Single Number II

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3


Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

*/
class Solution {
    public int singleNumber(int[] nums) {
        int num = 0, sum = 0;
        for(int i=0; i<32; i++) {
            for(int j=0; j<nums.length; j++) {
                sum += ((nums[j] >> i) & 1);
            }
            sum %= 3;
            num |= sum << i;
            sum = 0;
        }
        return num;
    }
}
