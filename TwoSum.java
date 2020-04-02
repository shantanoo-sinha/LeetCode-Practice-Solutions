/*
Two Sum
Reference: https://leetcode.com/problems/two-sum/
*/

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> lookup = new HashMap<Integer, Integer>(nums.length);
        lookup.put(target - nums[0], 0);
        
        int counter = 1, startIndex = -1, endIndex = -1;
        while(counter < nums.length) {
            if(lookup.get(nums[counter]) != null) {
                startIndex = lookup.get(nums[counter]);
                endIndex = counter;
                break;
            } else {
                lookup.put(target - nums[counter], counter);
            }
            counter++;
        }
        return new int[] {startIndex, endIndex};
    }
}
