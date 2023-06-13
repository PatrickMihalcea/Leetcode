// Medium. Binary Search.
// June 13 2023.
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minimumValue = nums[right];

        while (left <= right) {
            int rightVal = nums[right];
            int midPoint = (left + right) / 2;
            int midVal = nums[midPoint];

            if (midVal <= rightVal) {
                right = midPoint - 1;
            }
            else {
                left = midPoint + 1;
            }
            minimumValue = Math.min(minimumValue, midVal);
        }

        return minimumValue;
    }
}
