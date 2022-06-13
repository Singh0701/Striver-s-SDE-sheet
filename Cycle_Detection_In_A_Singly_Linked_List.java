// Problem Statement
// You have given a Singly Linked List of integers, determine if it forms a cycle or not.
// A cycle occurs when a node's next points back to a previous node in the list. The linked list is no longer linear with a beginning and end—instead, it cycles through a loop of nodes.
// Input Format :
// The first line of each test case contains the elements of the singly linked list separated by a single space and terminated by -1 and hence -1 would never be a list element.

// The second line contains the integer position "pos" which represents the position (0-indexed) in the linked list where tail connects to. If "pos" is -1, then there is no cycle in the linked list.
// Output Format :
// The only line of output contains 'true' if the linked list has a cycle or 'false' otherwise.

// You don't have to explicitly print by yourself. It has been taken care of.
// Constraints :
// 0 <= N <= 10^6
// -1 <= pos < N
// -10^9 <= data <= 10^9 and data != -1

// Where 'N' is the size of the singly linked list, "pos" represents the position (0-indexed) in the linked list where tail connects to and "data" is the Integer data of singly linked list.

// Time Limit: 1 sec
// Note :
// Try to solve this problem in O(N) Time Complexity and O(1) space Complexity


//Solution:

//Approach 1: Using Set data structure, we'll keep adding nodes into the set until head becomes null or if we found a node which is already in the set then return true. (As set doesn't allow duplicates).

import java.util.* ;
import java.io.*;
/*  

    Following is the representation of the Singly Linked List node

    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

*/

public class Solution {
   
    public static boolean detectCycle(Node<Integer> head) {
        //Create a Set to store nodes.
        Set<Node> set = new HashSet<>();
        //While loop while the head is not equal to null.
        while(head != null) {
            //If the node is already present in the set then return true. (Means cycle is present).
            if(set.contains(head))
                return true;
            //Else add the current node.
            set.add(head);
            //Move head to next node.
            head = head.next;
        }
        //Return false if we didn't find any cycle while running the above snippet of code.
        return false;
    }
}

//Time complexity = O(N)
//Space complexity = O(N)


//Approach 2: (Optimal approach) Using slow and a fast pointer. That is, we'll take slow and fast pointers and set initially to head. Now will run a while loop while the fast is not equal to null (Because if the cycle is not present then fast pointer will reach the last node first and get the null value). Inside loop will first move the slow pointer to next node and fast pointer to the next of the next node and then check if the slow is pointing to the same node as fast pointer (that is slow == fast) Which means cycle is present in the linked list, So return true. Else false outside the loop.

import java.util.* ;
import java.io.*;

public class Solution {
   
    public static boolean detectCycle(Node<Integer> head) {
        //Check if the list is empty or just one node is present, then no cycle can be found! Return false.
        if(head == null || head.next == null) return false;
        //Take slow and fast pointers, initialize to head.
        Node slow = head, fast = head;
        //Iterate over the list while fast pointer is not equal to null.
        while(fast != null) {
            //Move slow pointer by one.
            slow = slow.next;
            //Check if the fast is at the last node and return false, otherwise it'll show an null pointer exception error for accessing null.next.
            if(fast.next == null) return false;
            //Move fast.
            fast = fast.next.next;
            //If the slow and fast are pointing to the same node, which implies that there is a cycle present in the linked list, so return true.
            if(slow == fast)
                return true;
        }
        //Return false as no cycle found.
        return false;
    }
}


//Time complexity = O(N)
//Space complexity = O(1)
