/*
Two Sum II - Input array is sorted
Reference: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int arrLength = numbers.length;
        int startIndex = 0, endIndex = -1;
        int i = arrLength - 1;
        while (i >= 0) {
            if(numbers[i] + numbers[startIndex] == target) {
                startIndex++;
                endIndex = i+1;
                break;
            } else if(numbers[i] + numbers[startIndex] < target) {
                startIndex++;
                continue;
            } else if(numbers[i] + numbers[startIndex] > target) {
                i--;
                continue;
            } else {
                return new int[]{0, 0};
            }
        }
        return new int[] {startIndex, endIndex};
    }
}
