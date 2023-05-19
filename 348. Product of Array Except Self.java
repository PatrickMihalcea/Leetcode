// Medium. Arrays and Hashing.
// May 19 2023

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, 1);

        // Find prefix products.
        int prefixProduct = 1;
        for (int i = 0; i < len; i++) {
            ans[i] *= prefixProduct;
            prefixProduct *= nums[i];
        }

        // Find suffix products.
        int suffixProduct = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return ans;
    }
}
