/*

Reference: https://leetcode.com/problems/backspace-string-compare/

844. Backspace String Compare
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:
1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.

Follow up:
Can you solve it in O(N) time and O(1) space?

*/
class Solution {
    public boolean backspaceCompare(String S, String T) {
		int sLen = S.length() - 1, tLen = T.length() - 1;
		int skipS = 0, skipT = 0;
		while (sLen >= 0 || tLen >= 0) {
			while (sLen >= 0) {
				if (S.charAt(sLen) == '#') {
					skipS++;
					sLen--;
				} else if (skipS > 0) {
					skipS--;
					sLen--;
				} else {
					break;
				}
			}
			while (tLen >= 0) {
				if (T.charAt(tLen) == '#') {
					skipT++;
					tLen--;
				} else if (skipT > 0) {
					skipT--;
					tLen--;
				} else {
					break;
				}
			}

			if (sLen >= 0 && tLen >= 0 && S.charAt(sLen) != T.charAt(tLen)) {
				return false;
			}
			if ((sLen >= 0) != (tLen >= 0)) {
				return false;
			}
			sLen--;
			tLen--;
		}
		return true;
	}
}
