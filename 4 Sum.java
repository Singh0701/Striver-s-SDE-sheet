//Approach 1: Binary serach with # Pointers.

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quads = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        if(n < 4) return quads;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n - 1; k++) {
                    //Take the elements at i, j and kth index and search for the remaining sum in right part.
                    long key = (long)target - (long)nums[i] - (long)nums[j] - (long)nums[k];
                    int index = binarySearch(nums, k + 1, n - 1, key);
                    if(index != -1) {
                        List<Integer> subList = new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[index]));
                        if(!set.contains(subList)) {
                            set.add(subList);
                            quads.add(subList);
                        }
                    }
                }
            }
        }
        return quads;
    }
  
  
    //Binary Search function.  
    public int binarySearch(int[] arr, int low, int high, long key) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if((long)arr[mid] == key) return mid;
            if((long)arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

//Time complexity = O(N*Log(N)) + (N^3 * Log(N))
//Space complexity = O(N)


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> quads = new ArrayList<>();
        if(n < 4) return quads;
        Arrays.sort(nums);
        
        for(int i = 0; i < n - 1; i++) {
            
            for(int j = i + 1; j < n - 2; j++) {
                
                int low = j + 1;
                int high = n - 1;
                long key = (long)target - (long)nums[i] - (long)nums[j];
                
                while(low < high) {
                    long sum = (long)nums[low] + (long)nums[high];
                    if(sum == key) {
                        quads.add(new ArrayList<>(List.of(nums[i], nums[j], nums[low], nums[high])));
                        int temp = nums[j];
                        while(low < high && nums[low] == temp) ++low;
                        temp = nums[high];
                        while(low < high && nums[high] == temp) --high;
                    } 
                    else if(sum < key)
                        low++;
                    else high--;
                }
                while(j + 1 < n && nums[j + 1] == nums[j]) ++j;
            }
            
            while(i + 1 < n && nums[i + 1] == nums[i]) ++i;
        }
        return quads;
    }
}

//Time complexity = O(N*Log(N)) + (N^3)
//Space complexity = O(1)
//Approach 2: Using Two pointer and sorting.
