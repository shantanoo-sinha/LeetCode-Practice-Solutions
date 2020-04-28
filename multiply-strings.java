/*

Reference: https://leetcode.com/problems/multiply-strings/

43. Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

Note:
    The length of both num1 and num2 is < 110.
    Both num1 and num2 contain only digits 0-9.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        
        int[] multiply = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1; i>=0; i--) {
            for(int j=num2.length()-1; j>=0; j--) {
                //Changing this
                //int product = Integer.parseInt(""+num1.charAt(i)) * Integer.parseInt(""+num2.charAt(j));
                //to below saved much time
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                multiply[i+j+1] += product%10;
                multiply[i+j] += product/10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=multiply.length-1; i>0; i--){
            sb.append(multiply[i]%10);
            multiply[i-1] += multiply[i]/10;
        }
        
        if(multiply[0] != 0)
            sb.append(multiply[0]);
        return sb.reverse().toString();
    }
}
