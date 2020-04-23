/*

Reference: https://leetcode.com/problems/bitwise-and-of-numbers-range/

201. Bitwise AND of Numbers Range

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:
Input: [5,7]
Output: 4

Example 2:
Input: [0,1]
Output: 0

*/
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while(m < n) 
        {  
            // -n is the 2's complement of n when do bitwise or with n  
            // we get LSB and we subtract that from n
            n -= (n & -n);  
        }  
        return n;
    }
}
