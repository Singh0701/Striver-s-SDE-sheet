// Problem Statement
// You're given string ‘STR’ consisting solely of “{“, “}”, “(“, “)”, “[“ and “]” . Determine whether the parentheses are balanced.
    
// Solution: 

// Approach 1: Using Stack data structure, we'll iterate through the the string char by char and check for following three conditions and do perform action accordingly.
// 1. If the char is '(' then will push ')' into stack so that when we find it's closing brace ')' we can simply match with it stack peek() value and pop() it's equal, else return false.
// 2. If the char is '[' then will push ']' into stack.
// 3. If the char is '{' then will push '}' into stack.

import java.util.*;
import java.io.*;

public class Solution {
    public static boolean isValidParenthesis(String expression) {
        Stack<Character> stack = new Stack<>();
        for(char c: expression.toCharArray()) {
            //If the char is '{' then will push '}' into stack.
            if(c == '{')
                stack.add('}');
            //If the char is '[' then will push ']' into stack.
            else if(c == '[')
                stack.add(']');
            //If the char is '(' then will push ')' into stack
            else if(c == '(')
                stack.add(')');
            //if it's the closing brace for current parentheses then pop().
            else if(!stack.isEmpty() && c == stack.peek())
                stack.pop();
            //else return false.
            else return false;
        }
        //If stack empty means true, that is string is balanced.
        return stack.isEmpty();
    }
}


//Time comlexity = O(N);
//Space complexity = O(N);
