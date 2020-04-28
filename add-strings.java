/*

Reference: https://leetcode.com/problems/add-strings/

415. Add Strings

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:
    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/
class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.equals(0))
            return num2;
        else if(num2.equals(0))
            return num1;
        else {
            int i=num1.length(), j=num2.length();
            int k=Math.max(i,j);
            int[] sum = new int[k + 1];
            while(i > 0 && j > 0) {
                int add = (num1.charAt(--i) - '0') + (num2.charAt(--j) - '0');
                sum[k--] += add%10;
                sum[k] += add/10;
            }
            
            while(i>0) {
                sum[k--] += (num1.charAt(--i) - '0');
            }
            
            while(j>0) {
                sum[k--] += (num2.charAt(--j) - '0');
            }
            
            StringBuilder sb = new StringBuilder();
            for(int l=sum.length-1; l>0; l--){
                sb.append(sum[l]%10);
                sum[l-1] += sum[l]/10;
            }

            if(sum[0] != 0)
                sb.append(sum[0]);
            return sb.reverse().toString();
        }
    }
}
