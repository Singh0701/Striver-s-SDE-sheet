// Probleem statement: Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
// It is guaranteed that the node to be deleted is not a tail node in the list.
  
//   Example 1:
//     Input: head = [4,5,1,9], node = 5
//     Output: [4,1,9]
//     Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your         function.

      
      
 //Solution: 
      
//  Apporach 1: As we are gievn with the node to be deleted and the fact that it is not the tail (last) node in the linked list then we'll just copy the value of next node into the gievn node and then delete the next node.
   
   
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //Copyingg the value of next node into node.
        node.val = node.next.val;
        //Deleting the next node
        node.next = node.next.next;
    }
}

// Time Complexity: O(1)
// Space Complexity: O(1)
