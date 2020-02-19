/*

7. Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Reference: https://leetcode.com/problems/reverse-integer/

*/

class Solution {
    public int reverse(int x) {
        if(x==0)
            return 0;
        
        char[] charArr = String.valueOf(x).toCharArray();
        int start = 0, end = charArr.length - 1;
        int trailingZeros = 0;
        if(String.valueOf(charArr[start]).equals("+") || String.valueOf(charArr[start]).equals("-"))
            start++;
        while(end>start) {
            if(String.valueOf(charArr[end]).equals("0")) {
                trailingZeros++;
                end--;
            }
            else
                break;
        }
        for(int i=start; i<end; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[end];
            charArr[end--] = temp;
        }
        
        Long returnVal = Long.parseLong(String.valueOf(charArr));
        
        if(trailingZeros>0)
            returnVal = Math.round(returnVal/Math.pow(10, trailingZeros));
        
        return (returnVal>Integer.MAX_VALUE || returnVal<Integer.MIN_VALUE) ? 0 : returnVal.intValue();
    }
}
