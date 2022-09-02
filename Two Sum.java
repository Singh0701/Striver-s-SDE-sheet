//Approach 1: Brute force.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] pair = new int[2];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[j] == target - nums[i]) {
                    pair[0] = i;
                    pair[1] = j;
                    break;
                }
            }
        }
        return pair;
    }
}


//Time complexity = O(N^2)
//Space complexity = O(1)

//Approach 2: Using HashMap.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] pair = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(target - nums[i])) {
                pair[0] = i;
                pair[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return pair;
    }
}


//Time complexity = O(N)
//Space complexity = O(N)
