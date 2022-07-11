// Problem Statement: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  
//   Example 1:

//     Input: l1 = [2,4,3], l2 = [5,6,4]
//     Output: [7,0,8]
//     Explanation: 342 + 465 = 807.



//Solution:

//Approach 1: Optimal (Elementary Math). Will create a new Linked List to store the result. assign a temp to head of new list, and maintain two variable sum and carry intialize to 0, then run a while loop while l1 is not nul or l2 isn't null or the value of carry > 0. 

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
        int carry = 0;
        ListNode result = new ListNode(0), temp = result;
        while(l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            temp.next = new ListNode(sum % 10);
            carry = sum/10;
            temp = temp.next;
        }
        return result.next;
    }
}



//Time complexity = O(M)   M is the max length among l1 and l2 Linked list.
//Space complexity = O(M)
