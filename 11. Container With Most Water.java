// Medium. Two Pointers.
// May 24 2023
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        int width = height.length - 1;

        while (left < right) {
            max = Math.max(max, width * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
            width--;
        }

        return max;
    }
}
