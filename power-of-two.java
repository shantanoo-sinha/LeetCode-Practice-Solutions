/*

Reference: https://leetcode.com/problems/power-of-two/

231. Power of Two

Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1

Example 2:

Input: 16
Output: true
Explanation: 24 = 16

Example 3:

Input: 218
Output: false

*/
// Approach 1
class Solution {
    public boolean isPowerOfTwo(int n) {
        // Bit Manipulation property i.e. n & (n-1) == 0 for powerOfTwo numbers
        return (n > 0) && (n & (n-1)) == 0;
    }
}

// Approach 2
class Solution {
    public boolean isPowerOfTwo(int n) {        
        // Cout number of set bits in the number
        // For power of tow numbers, only 1 bit should be set
        int numOfSetBits = 0;
        while(n > 0) {
            if((n & 1) == 1)
                numOfSetBits++;
            n >>= 1;
        }
        return numOfSetBits == 1 ? true : false;
    }
}

// Approach 3
class Solution {
    public boolean isPowerOfTwo(int n) {
        // Iteratively divide by 2 and check
        if(n <= 0)
            return false;
        
        while((n % 2) == 0) {
            n = n/2;
        }
        return n == 1 ? true : false;
    }
}
