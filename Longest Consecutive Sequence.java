//Approach 1: Using sorting.

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        //If the array is empty then return 0 as max length.
        if(n == 0) return 0;
        //Sort the array.
        Arrays.sort(nums);
        //Take max and a counter variable set to 1.
        int max = 1, count = 1;
        //Store the first element as previous and start the loop from index 1.
        int prev = nums[0];
        for(int i = 1; i < n; i++) {
            //If the current element is next element of prev then increment the count variable.
            if(nums[i] == prev + 1) {
                count++;
            } 
            //Else set counter back to 1.
            else if(nums[i] != prev) {
                count = 1;
            }
            //keep updating the previous and the max value.
            prev = nums[i];
            max = Math.max(count, max);
        }
        //return the max.
        return max;
    }
}

//Time complexity = O(N*Log(N)) + O(N)
//Space complexity = O(1)

//Approach 2: Using HashSet.

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        //If the array is empty then return 0 as max length.
        if(n == 0) return 0;
        //Sort the array.
        int max = 1;
        Set<Integer> set = new HashSet<>();
        //Store all elements into the set.
        for(int i: nums) {
            set.add(i);
        }
        //Iterate over elements.
        for(int i: nums) {
            //If this is the minimum, check for all it's consecutive elements and increment counter.
            if(!set.contains(i - 1)) {
                int count = 0;
                while(set.contains(i)) {
                    i++;
                    count++;
                }
                //Update max length.
                max = Math.max(max, count);
            }
        }
        return max;
    }
}

//Time complexity = O(N)
//Space complexity = O(N)
