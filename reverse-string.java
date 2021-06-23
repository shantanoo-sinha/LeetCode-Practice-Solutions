/*

Reference: https://leetcode.com/problems/reverse-string/

344. Reverse String

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.


Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

*/
// Approach 1 - Iterative
class Solution {
    public void reverseString(char[] s) {
        if(s == null)
            return;
        int start = 0, end = s.length-1;
        while(start < end) {
            char c = s[start];
            s[start++] = s[end];
            s[end--] = c;
        }
    }
}


// Approach 2 - Recursive
class Solution {
    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
    }
    
    private void reverse(char[] s, int left, int right) {
        if(left >= right)
            return;
        
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        reverse(s, left, right);
    }
}
