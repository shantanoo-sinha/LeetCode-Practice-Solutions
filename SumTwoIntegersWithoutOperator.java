/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:
Input: a = 1, b = 2
Output: 3

Example 2:
Input: a = -2, b = 3
Output: 1

Ref: https://leetcode.com/problems/sum-of-two-integers/
*/

class Solution {
    public int getSum(int a, int b) {
        int sum = 0, carry = -1;
        while (carry != 0) {
            sum = a ^ b;
            carry = a & b;
            a = sum;
            b = carry<<1;
        }
        return a;
    }
}
