/*

Reference: https://leetcode.com/problems/reverse-vowels-of-a-string/

345. Reverse Vowels of a String

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"

Example 2:

Input: "leetcode"
Output: "leotcede"

Note:
The vowels does not include the letter "y".

*/
class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.isEmpty())
            return s;
        int start = 0, end = s.length()-1;
        Set<Character> vowels = new HashSet<>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        char[] arr = s.toCharArray();
        while(start < end) {
            if(!vowels.contains(arr[start]))
                start++;
            else if(!vowels.contains(arr[end]))
                end--;
            else {
                char c = arr[start];
                arr[start++] = arr[end];
                arr[end--] = c;
            }
        }
        return new String(arr);
    }
}
