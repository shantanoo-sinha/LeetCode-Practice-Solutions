/*

Reference: https://leetcode.com/problems/single-number-iii/

260. Single Number III

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]

Note:
    The order of the result is not important. So in the above example, [5, 3] is also correct.
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

*/
class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for(int num : nums) {
            x ^= num;
        }
        
        int i = 0;
        while (((x>>i) & 1) == 0)
            i++;
        // x &= -x;
        
        int a = 0, b = 0;
        for(int num : nums) {
            if(((num >> i) & 1) == 0)
            // if((num & x) == 0)
                a ^= num;
            else
                b ^= num;
        }
        return new int[] {a, b};
    }
}

//Slightly modified for finding the last set bit
class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for(int num : nums) {
            x ^= num;
        }
        
        x &= -x;
        
        int a = 0, b = 0;
        for(int num : nums) {
            if((num & x) == 0)
                a ^= num;
            else
                b ^= num;
        }
        return new int[] {a, b};
    }
}
