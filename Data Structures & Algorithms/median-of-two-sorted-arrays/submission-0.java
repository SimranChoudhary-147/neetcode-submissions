class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        int low = 0;
        int high = n;

        while (low <= high) {

            int partition1 = low + (high - low) / 2;
            int partition2 = (n + m + 1) / 2 - partition1;

            int left1 = (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int right1 = (partition1 == n)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            int left2 = (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int right2 = (partition2 == m)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            if (left1 <= right2 && left2 <= right1) {

                // Odd total length
                if ((n + m) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even total length
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            }

            // Move towards left in nums1
            else if (left1 > right2) {
                high = partition1 - 1;
            }

            // Move towards right in nums1
            else {
                low = partition1 + 1;
            }
        }

        return 0.0;
    }
}