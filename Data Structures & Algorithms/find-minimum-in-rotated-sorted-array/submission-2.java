class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element > right element → minimum lies in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise minimum lies in left half (including mid)
                right = mid;
            }
        }
        return nums[left]; // At the end, left == right → minimum element
    }
}
