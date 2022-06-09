// Problem Statement:
// You are given an array/list 'prices' where the elements of the array represent the prices of the stock as they were yesterday and indices of the array represent minutes. Your task is to find and return the maximum profit you can make by buying and selling the stock. You can buy and sell the stock only once.
// Note: You can’t sell without buying first.
// For Example:
// For the given array [ 2, 100, 150, 120],
// The maximum profit can be achieved by buying the stock at minute 0 when its price is Rs. 2 and selling it at minute 2 when its price is Rs. 150.
// So, the output will be 148.
   

// Solution:

// Approach 1: Brute force approach, In this we buy stock on day 0 and sell it on all days from 1 to n-1 and get the maximum profit, similarly for each 
// day we'll do and compute the max profit of all possible buy and sell combinations.


import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        int maxProfit = 0;
        //Check for all days combinations to sell the stock.
        for(int i = 0; i < prices.size(); i++) {
            for(int j = i + 1; j < prices.size(); j++) {
                int currentProfit = prices.get(j) - prices.get(i);
                //If profit is more then update the max profit.
                if(currentProfit > maxProfit)
                    maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }
}


// Time complexity = O((N^2)
// Space Complexity = O(1)


// Approach 2: Optimal Approach, In this, we will keep track of the minimum price so far till the ith day and sell on an ith day if the current profit 
// is more than the Maximum profit then will update the max profit.

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        //Initialize minimum price so far to day 0 price.
        int minPriceSoFar = prices.get(0);
        int maxProfit = 0;
        for(int i: prices) {
            //If min price so far is giving more profit then max profit then update max profit.
            if(maxProfit < i - minPriceSoFar)
                maxProfit = i - minPriceSoFar;
            //If the current day price is lower than minimum price so far then update minPriceSoFar.
            if(minPriceSoFar > i)
                minPriceSoFar = i;
        }
        //return the max profit.
        return maxProfit;
    }
}


// Time complexity = O((N)
// Space Complexity = O(1)
