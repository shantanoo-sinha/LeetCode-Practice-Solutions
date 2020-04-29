/*

Reference: https://leetcode.com/problems/add-two-numbers/

2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        int sum = l1.val + l2.val;
        ListNode result = new ListNode(sum%10);
        sum = sum / 10;
        ListNode head = result;
        l1 = l1.next;
        l2 = l2.next;
        while(l1!=null && l2!=null) {
            sum += l1.val + l2.val;
            result.next = new ListNode(sum%10);
            sum = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }
        while(l1!=null) {
            sum += l1.val;
            result.next = new ListNode(sum%10);
            sum = sum / 10;
            l1 = l1.next;
            result = result.next;
        }
        while(l2!=null) {
            sum += l2.val;
            result.next = new ListNode(sum%10);
            sum = sum / 10;
            l2 = l2.next;
            result = result.next;
        }
        if(sum>0){
            result.next = new ListNode(sum);
        }
            
        return head;
    }
}
