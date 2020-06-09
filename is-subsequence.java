/*

Reference: https://leetcode.com/problems/is-subsequence/

392. Is Subsequence

Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.


Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.

*/
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for(char c : t.toCharArray()) {
            if(i >= s.length())
                break;
            else if(s.charAt(i) == c)
                i++;
        }
        return (i == s.length()) ? true : false;
    }
}
