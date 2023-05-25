// Hard. Two Pointers.
// May 24 2023.
class Solution {
    public int trap(int[] height) {
        int maxL = 0;
        int maxR = 0;
        int left = 0;
        int right = height.length - 1;
        int ans = 0;

        while (left < right) {
            maxL = Math.max(maxL, height[left]);
            maxR = Math.max(maxR, height[right]);
            if (height[left] < height[right]) {
                if (height[left] != maxL) {
                    ans += Math.min(maxL, maxR) - height[left];
                }
                left++;
            }
            else {
                if (height[right] != maxR) {
                    ans += Math.min(maxL, maxR) - height[right];
                }
                right--;
            }
        }
        
        return ans;
    }
}
