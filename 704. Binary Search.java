// Easy. Binary Search.
// June 9 2023.
class Solution {
    public int search(int[] nums, int target) {
        // Binary Search.
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right)/2;
            int midVal = nums[mid];
            if (midVal > target) {
                right = mid - 1;
            }
            else if (midVal < target) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }

        return -1;
        
        // OR this one liner:
        // return (Arrays.binarySearch(nums, target) >= 0) ? Arrays.binarySearch(nums, target) : -1;
        
    }
}
