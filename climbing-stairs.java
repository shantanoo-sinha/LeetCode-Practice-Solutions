/*

Reference: https://leetcode.com/problems/climbing-stairs/

70. Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: 2
Output: 2

Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: 3
Output: 3

Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:
1 <= n <= 45

*/
//Recursive Solution
class Solution {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int climbStairs(int n) {
        return recurse(n);
    }
    
    private int recurse(int n) {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        
        if(map.containsKey(n))
           return map.get(n);
        
        int val = recurse(n-1) + recurse(n-2);
        map.put(n, val);
        return val;
    }
}

//Iterative Solution
class Solution {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        
        int step1 = 1, step2 = 2, totalSteps = 0;
        for(int i=2; i<n; i++) {
            totalSteps = step1 + step2;
            step1 = step2;
            step2 = totalSteps;
        }
        return totalSteps;
    }
}
