import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        int prev = nums.get(0);
        int prev2 = 0;
        for(int i = 1; i < n; i++) {
            int take = (i > 1) ? nums.get(i) + prev2 : nums.get(i);
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
		return prev;
	}
}
