/*

Reference: https://leetcode.com/problems/3sum

15. 3Sum

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []


Constraints:
    0 <= nums.length <= 3000
    -105 <= nums[i] <= 105

*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            if(i==0 || (i>0 && nums[i-1]!=nums[i])) {
                int sum = 0 - nums[i];
                int start = i+1, end = nums.length-1;
                while(start < end) {
                    if(nums[start] + nums[end] == sum) {
                        List temp = new ArrayList();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        output.add(temp);
                        while(start<end && nums[start] == nums[start+1])
                            start++;
                        while(start<end && nums[end] == nums[end-1])
                            end--;
                        start++;
                        end--;
                    } else if(nums[start] + nums[end] < sum)
                        start++;
                    else
                        end--;
                }
            }
        }
        return output;
    }
}
