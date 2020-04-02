/*

Reference:https://leetcode.com/problems/linked-list-cycle/

141. Linked List Cycle
Given a linked list, determine if it has a cycle in it.
To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.
3 -> 2 -> 0 -> -4 (pos tells that the last pointer is pointing to index 1 i.e. node with value 2)

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.
1 -> 2 (pos tells that the last pointer is pointing to index 0 i.e. node with value 1)

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
1 (pos tells that the last pointer is pointing to index -1 i.e. no cycle)

Follow up:
Can you solve it using O(1) (i.e. constant) memory?

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null || head.next.next == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(slow != fast) {
            if(slow.next != null)
                slow = slow.next;
            else
                return false;
            
            if(fast.next != null && fast.next.next != null)
                fast = fast.next.next;
            else
                return false;
        }
        return true;
    }
}
