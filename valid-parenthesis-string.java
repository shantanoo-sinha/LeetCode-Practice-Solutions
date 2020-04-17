/*

References: https://leetcode.com/problems/valid-parenthesis-string/

678. Valid Parenthesis String

Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
    An empty string is also valid.

Example 1:
Input: "()"
Output: True

Example 2:
Input: "(*)"
Output: True

Example 3:
Input: "(*))"
Output: True

Note:
    The string size will be in the range [1, 100].

*/
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<Integer>();
        Stack<Integer> star = new Stack<Integer>();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')
                left.push(i);
            else if(s.charAt(i) == '*')
                star.push(i);
            else {
                if(left.isEmpty() && star.isEmpty())
                    return false;
                else if(!left.isEmpty())
                    left.pop();
                else if(!star.isEmpty())
                    star.pop();
            }
        }
        while(!left.isEmpty() && !star.isEmpty()) {
            if(left.pop() > star.pop())
                return false;
        }
        return left.isEmpty();
    }
}
