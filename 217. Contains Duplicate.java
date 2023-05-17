// Easy. Arrays and Hashing.
// May 16 2023
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> table = new HashSet<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (table.contains(nums[i])) return true;
            table.add(nums[i]);
        }
        return false;
    }
}
