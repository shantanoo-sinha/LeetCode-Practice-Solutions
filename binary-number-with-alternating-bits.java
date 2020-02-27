/*

Reference: https://leetcode.com/problems/binary-number-with-alternating-bits/

693. Binary Number with Alternating Bits

Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101

Example 2:
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.

Example 3:
Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.

Example 4:
Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.

*/

class Solution {
    public boolean hasAlternatingBits(int n) {
        
        int lastBit = 0;
        
        if(n==0) 
            return true;
        else if(n%2!=0){
            lastBit = 1;
        }
        n=n/2;
        while (n>1) {
            if(n%2==0){
                if(0==lastBit)
                    return false;
                lastBit = 0;
            } else {
                if(1==lastBit)
                    return false;
                lastBit = 1;
            }
            n=n/2;
        }
        if(n==lastBit)
            return false;
        return true;
    }
}
