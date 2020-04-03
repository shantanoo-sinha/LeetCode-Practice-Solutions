/*

Reference: https://leetcode.com/problems/hamming-distance/

461. Hamming Distance

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:
Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

*/

class Solution {
    
       /*
       public int hammingDistance(int x, int y) {
              if(x<0 || y<0)
                     return 0;
              int a = x^y;
              int count = 0;
              while(a!=0) {
              if((a&1)==1)
                     count++;
                     a = a>>1;
              }
              return count;
       }
    */
    public int hammingDistance(int x, int y) {
        //Use XOR to calculate the number of bits different in both the numbers
        int xorValue = x^y;
        int hammingDistance = 0;
        //System.out.println(xorValue);
        while(xorValue != 0) {
            hammingDistance += (xorValue & 1);
            xorValue = xorValue >>> 1;
        }
        return hammingDistance;
    }
}
