/*

Reference: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

1047. Remove All Adjacent Duplicates In String

Complexity: Easy

You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.


Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:
Input: s = "azxxzy"
Output: "ay"


Constraints:
    1 <= s.length <= 105
    s consists of lowercase English letters.

*/
// Approach 1
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=1; i<sb.length(); i++) {
            if(sb.charAt(i) == sb.charAt(i-1)) {
                sb.delete(i-1, i+1);
                i = Math.max(0, i - 2);
            }
        }
        return sb.toString();
    }
}

// Approach 2 - Using Stack
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        
        for(int i=1; i<s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : stack)
            sb.append(c);
        
        return sb.toString();
    }
}
