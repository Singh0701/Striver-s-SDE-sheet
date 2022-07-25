// Problem Statement: The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

 

// Example 1:

// Input: n = 3, k = 3
// Output: "213"
// Example 2:

// Input: n = 4, k = 9
// Output: "2314"
// Example 3:

// Input: n = 3, k = 1
// Output: "123"


//Solution:

// Approach 1: Brute force, By computing all the possible permutations and sort them and then return kth (k - 1) permutation.
  
class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = i + 1;
        List<List<Integer>> result = new ArrayList<>();
        permutes(nums, new boolean[nums.length], result, new ArrayList<Integer>());
        StringBuilder sb = new StringBuilder();
        for(int i: result.get(k - 1))
            sb.append(i + "");
        return sb.toString();
    }
    
    
    public void permutes(int[] nums, boolean[] isMarked, List<List<Integer>> result, List<Integer> ds) {
        //Base case, when the size of current permutation becomes equal to nums array length, it means we got one of the permutation and we'll store it in the final result and return.
        if(ds.size() == nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }
        //Here we will loop through the whole array from 0 to n - 1 and check if the current element is not already considered will take that and make a recursion call else if the element is taken then just continue to next index/elements.
        for(int i = 0; i < nums.length; i++) {
            //If already taken, continue.
            if(isMarked[i]) continue;
            ds.add(nums[i]);
            isMarked[i] = true; //Mark true after adding into the ds.
            permutes(nums, isMarked, result, ds); //Make a recursion call.
            isMarked[i] = false;
            ds.remove(ds.size() - 1); //Remove the element and mark false after the above recursion call is completed.
        }
    }
}

// Time complexity: O(N! * N) +O(N! Log N!)
// The recursion takes O(N!)  time because we generate every possible permutation and another O(N)  time is required to make a deep copy and store every sequence in the data structure. Also, O(N! Log N!)  time required to sort the data structure 
// Space complexity: O(N) 



// Approach 2: Optimal, Using Maths.



  
