// Medium. Binary Search.
// June 14 2023
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midPoint = (left + right) / 2;
            int midVal = nums[midPoint];
            int leftVal = nums[left];
            int rightVal = nums[right];

            if (leftVal == target) return left;
            if (rightVal == target) return right;
            if (midVal == target) return midPoint;

            if (((target < midVal) && (target < leftVal)) || 
                ((target > midVal) && (target > leftVal))) {
                if (midVal < leftVal) {
                    right = midPoint - 1;
                }
                else {
                    left = midPoint + 1;
                }
            }
            else if ((target < midVal) && (target > leftVal)) {
                right = midPoint - 1;
            }
            else if ((target > midVal) && (target < leftVal)) {
                left = midPoint + 1;
            }
            else {
                return midPoint;
            }
        }

        return -1;

    }
}
