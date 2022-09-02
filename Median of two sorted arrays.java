class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
        int n = nums1.length;
        int m = nums2.length;
        int low = 0, high = n;
        int median = (m + n + 1) / 2;
        while(low <= high) {
            int mid1 = (high + low) >> 1;
            int mid2 = median - mid1;
            
            int left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int right1 = (mid1 == n) ? Integer.MAX_VALUE : nums1[mid1];
            int right2 = (mid2 == m) ? Integer.MAX_VALUE : nums2[mid2];
            
            if(left1 <= right2 && left2 <= right1) {
                if((n + m) % 2 == 0) return (Math.max(left1, left2) + Math.min(right1 , right2)) / 2.0;
                else return Math.max(left1, left2);
            }
            else if(left1 > right2) 
                high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0.0;
    }
}
