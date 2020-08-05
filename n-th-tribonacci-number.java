/*

Reference: https://leetcode.com/problems/n-th-tribonacci-number/

1137. N-th Tribonacci Number

The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

Example 1:
Input: n = 4
Output: 4

Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

Example 2:
Input: n = 25
Output: 1389537


Constraints:
0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

*/
// Iterative
class Solution {
    public int tribonacci(int n) {
        if(n<2)
            return n;
        if(n==2)
            return 1;
        int t0 = 0, t1 = 1, t2 = 1, tn = 0;
        for(int i=3; i<=n; i++) {
            tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
        return tn;
    }
}

// Recursive
class Solution {
    public int tribonacci(int n) {
        if(n==0)
            return 0;
        else if(n==1 || n==2)
            return 1;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        return recurse(n, arr);
    }
    private int recurse(int n, int[] arr) {
        if(n<=2)
            return arr[n];
        if(arr[n] == 0)
            arr[n] = recurse(n-1, arr) + recurse(n-2, arr) + recurse(n-3, arr);
        return arr[n];
    }
}
