// Problem statement: Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutes(nums, new boolean[nums.length], result, new ArrayList<Integer>());
        return result;
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


//Time complexity = O(N! * N) - N! forall the permutations recursive calls and N for the for loop from 0 to n we are running each time.
//Space Complexity = O(N! + N + N + N) - N! for storing the all permutations, N for ds ArrayList, another N for Boolean array, and N for recursion stack space.
