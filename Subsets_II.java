// Problem Statement: Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //Sorting the array to avoid generating duplicate subsets.
        Arrays.sort(nums);
        //getSubsets function parameters (index, nums array, result list, lisit to store the current subset combination);
        getSubsets(0, nums, result, new ArrayList<>());
        return result;
    }
    
    public void getSubsets(int index, int[] nums, List<List<Integer>> result, List<Integer> ds) {
        //Storing at first before any further recursive call because we will be storing each and every subset we generate.
        result.add(new ArrayList<>(ds));
        //If index goes out of bound then return.
        if(index >= nums.length) return;
        //For every index we have options to pick from index -> nums.length - 1, So for the same we'll run a for loop from index to length - 1.
        for(int i = index; i < nums.length; i++) {
            //If the current element has duplicates and it is not the first one (that is index != i or i > index) then we will not consider it to avoid duplicate subsets, and just continue to next index.
            if(i > index && nums[i] == nums[i - 1])
                continue;
            //Add the current element to be considered into the current subset.
            ds.add(nums[i]);
            //Make a recursion call with next index.
            getSubsets(i + 1, nums, result, ds);
            //Once the above recursion call is completed we need to remove the element we added.
            ds.remove(ds.size() - 1);
        }
    }
}


//Time complexity = O(2^n * k) + O(n*log(n))
//assuming k as the avg length of each subset we generate and it'll take O(k) time complexity to make a copy of the subset, and O(n*log(n)) for sorting array initially.
//Space complexity = O(2^n * k) + O(n)
//K is the Avg length of each subset, O(n) will be the stack space for recursion calls.
