//Recursion.

public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		int sum1 = 0;
        //Computing and storing the sum of all elements into sum1 which represents the first partition's sum.
        for(int i: arr)
            sum1 += i;
        //Calling the recursive function to try out all the possible subsets for the second partition and count the no. of partitions that satisfies the condition (sum1 >= sum2 && abs(sum1 - sum2) == D).
        return count(n - 1, arr, sum1, 0, d);
	}
    
    public static int count(int index, int[] arr, int sum1, int sum2, int d) {
        //Base case
        if(sum2 > sum1) return 0;
        if(index < 0) {
            return (sum1 >= sum2 && Math.abs(sum1 - sum2) == d) ? 1 : 0;
        }
        //Now you have two options for the current index, one is to pick and add it into the partition two and at same time remove from the first partition OR Not pick the current index and move to next.
        int notPick = count(index - 1, arr, sum1, sum2, d);
        int pick = (sum2 + arr[index] > sum1) ? 0 : count(index - 1, arr, sum1 - arr[index], sum2 + arr[index], d);
        return notPick + pick;
    }
}


//Tabulation.
