// Problem Statement: Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
    
// Solution:

// Approach 1: Brute Force, first we'll sort the intervals based on the start time (if not given in the question that array is already sorted). Then for each index i from 0 to n-1. check all j index (i < j < n) if the interval at the jth index is overlapping with the ith index then update the interval at ith index and at end of inner loop store the ith interval into the resultant 2d array that we'll return as answer.

// Time complexity = O(N*N + N*log(N))
// Space Complexity = O(N)
    


// Approach 2: Optimal Approach, sort the array first and now take a new data structure or just two start and end variables initially storing the values of 0th interval. now linearly iterate over the 2d array of intervals and check if the current ith index's interval is overlapping with the start and end, if yes then update the end to Max(end, i[1]) else add the start,end pair into result array and update start and end to the current index's interval's start and end value.\


class Solution {
    public int[][] merge(int[][] intervals) {
        //As java doesn't support dynamic 2d array, we'll take a List of int[] array type to store the merged intervals.
        List<int[]> result = new ArrayList<>();
        //Check for the edge case if the length of given intervals is 0 or the it's null then return the empty array.
        if(intervals == null || intervals.length < 0)
            return result.toArray(new int[0][]);
        //As discussed above, we'll sort the given intervals array.
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        //Take the pair of start and end to store the interval of new merged interval.
        int start = intervals[0][0];
        int end = intervals[0][1];
        //Linearly traversing the intervals.
        for(int[] row: intervals) {
            //If the current interval is overlapping with the start,end pair then merge them and update the end value accordingly.
            if(row[0] <= end)
                end = Math.max(row[1], end);
            //Else, that is we covered all overlappings till this index - 1, so this will be the new index. We'll store the start,end we calculated till now into the resultant list and then update the start and end variables.
            else {
                result.add(new int[]{start, end});
                start = row[0];
                end = row[1];
            }
        }
        //Add the last remaining inetrval into result.
        result.add(new int[]{start, end});
        //Now return the result by converting it into a 2d int array.
        return result.toArray(new int[0][]);
    }
}


// Time complexity = O(N + N*log(N))
// Space Complexity = O(N)
    
