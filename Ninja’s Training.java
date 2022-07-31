Problem Statement: A Ninja has an ‘N’ Day training schedule. He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day. There are merit points associated with performing an activity each day. The same activity can’t be performed on two consecutive days. We need to find the maximum merit points the ninja can attain in N Days.

We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point of specific activity on that particular day. Our task is to calculate the maximum number of merit points that the ninja can earn.


Sample Input 1:
2
3
1 2 5 
3 1 1
3 3 3
3
10 40 70
20 50 80
30 60 90
Sample Output 1:
11
210
Explanation Of Sample Input 1:
For the first test case,
One of the answers can be:
On the first day, Ninja will learn new moves and earn 5 merit points. 
On the second day, Ninja will do running and earn 3 merit points. 
On the third day, Ninja will do fighting and earn 3 merit points. 
The total merit point is 11 which is the maximum. 
Hence, the answer is 11.

For the second test case:
One of the answers can be:
On the first day, Ninja will learn new moves and earn 70 merit points. 
On the second day, Ninja will do fighting and earn 50 merit points. 
On the third day, Ninja will learn new moves and earn 90 merit points. 
The total merit point is 210 which is the maximum. 
Hence, the answer is 210.
  
  
  
  
  
//Solution:
  
//Approach 1: Using Recursion.
  
import java.util.*;
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        return getMax(n - 1, points, 3);
    }
    public static int getMax(int day, int points[][], int lastTask) {
        //Base Case
        if(day == 0) {
            //Try to select task except the last one, which gives maximum points.
            int maxPoints = 0;
            //Try for all 3 tasks, and check if it is same as task performed on the previous day or not.
            for(int task = 0; task < 3; task++) {
                if(task != lastTask) {
                    maxPoints = Math.max(maxPoints, points[day][task]);
                }
            }
            //Return max of all.
            return maxPoints;
        }
        //For day 1 to n - 1.
        int maxPoints = 0;
        //Try out all 3 tasks and check if it is same as task performed on the previous day or not.
        for(int task = 0; task < 3; task++) {
            int point = 0;
            if(task != lastTask) {
                //Take the points of the selected task and go to previous day and make sure to pass on the task selected as last parameter in function call.
                point = points[day][task] + getMax(day - 1, points, task);
            }
            //Take the maximum of all.
            maxPoints = Math.max(maxPoints, point);
        }
        //Return the Maximum Points obtained.
        return maxPoints;
    }
}

//Approach 2: Using Recursion with Memoization.


import java.util.*;
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        //Make a 2D array to store the overlapping sub-problems.
        int[][] dp = new int[n][4];
        return getMax(n - 1, points, 3, dp);
    }
    public static int getMax(int day, int points[][], int lastTask, int[][] dp) {
        //Base Case
        if(day == 0) {
            //Try to select task except the last one, which gives maximum points.
            int maxi = 0;
            //Try for all 3 tasks, and check if it is same as task performed on the previous day or not.
            for (int task = 0; task < 3; task++) {
                if (task != lastTask)
                    maxi = Math.max(maxi, points[0][task]);
            }
            //Store the result in dp array.
            return dp[day][lastTask] = maxi;
        }
        //Check if this computation is already done. If yes then return it, else compute it and then store it into the array.
        if(dp[day][lastTask] != 0) return dp[day][lastTask];
        //For day 1 to n - 1.
        int maxPoints = 0;
        //Try out all 3 tasks and check if it is same as task performed on the previous day or not.
        for(int task = 0; task < 3; task++) {
            if(task != lastTask) {
                //Take the points of the selected task and go to previous day and make sure to pass on the task selected as last parameter in function call.
                int point = points[day][task] + getMax(day - 1, points, task, dp);
                maxPoints = Math.max(maxPoints, point);
            }
            //Take the maximum of all.
        }
        //Return the Maximum Points obtained.
        return dp[day][lastTask] = maxPoints;
    }
}

// Time Complexity: O(N*4*3)
// Space Complexity: O(N) + O(N*4)


//Approach 3: Using Tabulation.

import java.util.*;
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        //Make a 2D array to store the overlapping sub-problems.
        int[][] dp = new int[n][4];
        //Save the base case values, That is for day 0.
        dp[0][0] =Math.max(points[0][1], points[0][2]);
        dp[0][1] =Math.max(points[0][0], points[0][2]);
        dp[0][2] =Math.max(points[0][0], points[0][1]);
        dp[0][3] =Math.max(dp[0][0], dp[0][1]);
        //Start from day 1 as day 0 has been already computed.
        for(int day = 1; day < n; day++) {
            //Last task value can range from 0 to 3 So we'll run a loop for same.
            for(int lastTask = 0; lastTask < 4; lastTask++) {
                //Try to perform all tasks from 0 to 2.
                for(int task = 0; task < 3; task++) {
                    //If it's not same as the task performed on previous day.
                    if(task != lastTask) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][lastTask] = Math.max(dp[day][lastTask], point);
                    }
                }
             }
        }
        return dp[n - 1][3];
    }
}


//Approach 4: Space Optimization for Tabulation Approach.

