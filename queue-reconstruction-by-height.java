/*

Reference: https://leetcode.com/problems/queue-reconstruction-by-height/

406. Queue Reconstruction by Height

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

*/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort the array descending based on people[i][0]
        // if(people[i][0] == people[j][0]), the sort them descending based on people[i][1]
        //
        // Now, the index people[i][1] gives its position in the sorted array
        Arrays.sort(people, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]);
            }
        });
        List<int[]> list = new LinkedList<>();
        for(int[] arr : people)
            list.add(arr[1], arr);
        return list.toArray(new int[people.length][]);
    }
}
