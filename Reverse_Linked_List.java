// Problem Statement
// Given a singly linked list of integers. Your task is to return the head of the reversed linked list.
// For Example:
// The given linked list is 1 -> 2 -> 3 -> 4-> NULL. Then the reverse linked list is 4 -> 3 -> 2 -> 1 -> NULL and the head of the reversed linked list will be 4.

// Solution:

// Approach 1: Using stack data structure to reverse the linked list, as stack follows last in first out concept.
    
    
import java.util.*;
import java.io.*; 
/*
    Following is the structure of the Singly Linked List.    
    class LinkedListNode<T> 
    {
        T data;
        LinkedListNode<T> next;
        public LinkedListNode(T data) 
        {
            this.data = data;
        }
    }

*/
public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        Stack<LinkedListNode> stack = new Stack<>();
        LinkedListNode temp = head;
        //Storing all the nodes in the stack.
        while(temp != null) {
            stack.push(temp);
            LinkedListNode prev = temp;
            temp = temp.next;
            //Making each's next pointer equal to null to avoid cycles.
            prev.next = null;
        }
        LinkedListNode newHead = new LinkedListNode(0);
        temp = newHead;
        //Creating a new Linked List and adding nodes by popping out nodes from the stack.
        while(!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        //Initial node is of no use as we created above just to create a new list.
        newHead = newHead.next;
        return newHead;
    }
}

//Time complexity = O(N)
//Space Complexity = O(N)
