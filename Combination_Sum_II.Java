// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, candidates, target, result, new ArrayList<>(), candidates.length);
        return result;
    }
    
    //Recursive function to Find all combinations.
    public void findCombinations(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> ds, int n) {
        if(target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index; i < n; i++) {
            //If the duplicates elements are present and it is not the first one then no need to pick and continue.
            if(i > index && candidates[i] == candidates[i - 1])
                continue;
            //If the current element is exceeding target then no use of picking up this element and any other in right of it so just break out of the loop.
            if(target < candidates[i])
                break;
            //Add the element to our ds.
            ds.add(candidates[i]);
            //Now make a recursive call to evaluate if the current element can be in one of the valid combinations.
            findCombinations(i + 1, candidates, target - candidates[i], result, ds, n);
            //Remove the added element when backtracking.
            ds.remove(ds.size() - 1);
        }
    }
}

