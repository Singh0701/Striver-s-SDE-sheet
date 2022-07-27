// Problem Statement: Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. At a time the frog can climb either one or two steps. A height[N] array is also given. Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.
  
  
// Sample Input 1:
// 2
// 4

// 10 20 30 10
// 3
// 10 50 10
// Sample Output 1:
// 20
// 0
// Explanation Of Sample Input 1:
// For the first test case,
// The frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost).
// Then a jump from the 2nd stair to the last stair (|10-20| = 10 energy lost).
// So, the total energy lost is 20 which is the minimum. 
// Hence, the answer is 20.

// For the second test case:
// The frog can jump from 1st stair to 3rd stair (|10-10| = 0 energy lost).
// So, the total energy lost is 0 which is the minimum. 
// Hence, the answer is 0.
  
  
//Solution: 

//Approach 1 Recursion

import java.util.*;
public class Solution {
    public static int frogJump(int n, int heights[]) {
        return jump(n - 1, n, heights);
    }
    public static int jump(int index, int n, int[] heights) {
        if(index == 0) return 0;
        int left = jump(index - 1, n, heights) + Math.abs(heights[index] - heights[index - 1]);
        int right = left;
        if(index > 1) {
            right = jump(index - 2, n, heights) + Math.abs(heights[index] - heights[index - 2]);
        }
        return Math.min(left, right);
    }
}

//Approach 2: DP Memoization (Top Down).


import java.util.*;
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n + 1];
        return jump(n - 1, heights, dp);
    }
    public static int jump(int index, int[] heights, int[] dp) {
        if(index == 0) return 0;
        if(dp[index] != 0) return dp[index]; 
        int left = jump(index - 1, heights, dp) + Math.abs(heights[index] - heights[index - 1]);
        int right = left;
        if(index > 1) {
            right = jump(index - 2, heights, dp) + Math.abs(heights[index] - heights[index - 2]);
        }
        return dp[index] = Math.min(left, right);
    }
}


//Approach 3 : Tabulation (Bottom Up).
import java.util.*;
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        for(int i = 1; i < n; i++) {
            int first = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int second = first;
            if(i > 1) second = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(first, second);
        }        
        return dp[n - 1];
    }
}


//Approach 4: Space Optimized.

import java.util.*;

public class Solution {
    public static int frogJump(int n, int heights[]) {
        int p1 = 0, p2 = 0;
        for(int i = 1; i < n; i++) {
            int first = p1 + Math.abs(heights[i] - heights[i - 1]);
            int second = first;
            if(i > 1) second = p2 + Math.abs(heights[i] - heights[i - 2]);
            int current = Math.min(first, second);
            p2 = p1;
            p1 = current;
        }        
        return p1;
    }
}
