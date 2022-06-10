// Problem Statement
// You have given a Singly Linked List of integers, determine if it forms a cycle or not.
// A cycle occurs when a node's next points back to a previous node in the list. The linked list is no longer linear with a beginning and end—instead, it cycles through a loop of nodes.
// Note: Since, it is binary problem, there is no partial marking. Marks will only be awarded if you get all the test cases correct.
// Input Format :
// The first line of each test case contains the elements of the singly linked list separated by a single space and terminated by -1 and hence -1 would never be a list element.

// The second line contains the integer position "pos" which represents the position (0-indexed) in the linked list where tail connects to. If "pos" is -1, then there is no cycle in the linked list.
// Output Format :
// The only line of output contains 'true' if linked list has a cycle or 'false' otherwise.

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

//Approach 1: Using Set data structure, we'll keep adding nodes into set until head becomes null or if we found an node which is already in the set then return true. (As set doesn't allows duplicates).

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
        //Return false if we didn't found any cycle while running the above snippet of code.
        return false;
    }
}

//Time complexity = O(N)
//Space complexity = O(N)
