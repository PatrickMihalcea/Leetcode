// Medium. Two Pointers.
// May 24 2023
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            int target = 0 - nums[i];
            while (start < end) {
                int coupleSum = nums[start] + nums[end];
                if (coupleSum > target) {
                    while ((nums[end-1] == nums[end]) && (start < end)) {
                        end--;
                    }
                    end--;
                    continue;
                }
                else if (coupleSum == target) {
                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
                }
                while ((nums[start+1] == nums[start]) && (start < end - 1)) {
                    start++;
                }
                start++;
            }

            // Ensure no duplicate triplets by incrementing i until first value is different.
            while ((nums[i+1] == nums[i]) && (i < nums.length-2)) {
                i++;
            }
        }

        return ans;

    }
}
