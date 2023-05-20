// Medium. Arrays and Hashing.
// May 20 2023.
class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (set.containsKey(val)) {
                continue;
            }

            if (set.containsKey(val + 1)) {
                if (set.containsKey(val - 1)) {
                    set.put(val, set.get(val + 1) + set.get(val - 1) + 1);
                    // Set endpoints to new count.
                    set.replace(val + set.get(val + 1), set.get(val));
                    set.replace(val - set.get(val - 1), set.get(val));
                } else {
                    set.put(val, set.get(val + 1) + 1);
                    set.replace(val + set.get(val + 1), set.get(val));
                }
            } 
            else if (set.containsKey(val - 1)) {
                set.put(val, set.get(val - 1) + 1);
                set.replace(val - set.get(val - 1), set.get(val));
            } 
            else {
                set.put(val, 1);
            }

            ans = Math.max(set.get(val), ans);

        }

        return ans;

    }
}
