// Problem Statement: Given two singly linked lists that are sorted in increasing order of node values, merge two sorted linked lists and return them as a sorted list. 
// The list should be made by splicing together the nodes of the first two lists.
  
// Example 1:

// Input Format :
// l1 = {3,7,10}, l2 = {1,2,5,8,10}

// Output :
// {1,2,3,5,7,8,10,10}


// Solution:

// Approach 1: Using Extra space, in this approach we'll create a new dummy linked list head and add nodes by taking min of pointers p1 and p2 from List1 and List2 and move each pointer accordingly. At the end just copying the whole list (either list1 or lsit2, whichever is not null).
  
// Steps:
// 1. Take pointer p1 pointing to head of list1 and p2 pointing to head of list2.
// 2. Run a while lopp while both p1 and p2 are not equal to null.
// 3. Check if p1.val < p2.val then add p1 node to the dummy list else add p2 node to the dummy list.
// 4. Outside the above while loop run 2 separate while loop's for each list1 and list2 because it might be the case that both list1 and list 2 are not of equal length 
//    or the pointer p1/p2 is not null yet. So just copy the remaining values from that list.
// 5. Return the head to new Dummy list we created.  
  
  
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        while(list1 != null) {
            temp.next = list1;
            temp = temp.next;
            list1 = list1.next;
        }
        while(list2 != null) {
            temp.next = list2;
            temp = temp.next;
            list2 = list2.next;
        }
        return head.next;
    }
}


// Time complexity = O(N+M)
// Space complexity = O(1)
// Where N and M are size of list1 and list2 respectively.  


