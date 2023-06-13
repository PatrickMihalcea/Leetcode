// Medium. Binary Search.
// June 13 2023
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length - 1];
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int hours = 0;
            int i = 0;
            while ((i < piles.length) && (hours <= h)) {
                hours += (int) Math.ceil(((double) piles[i] / (double) mid));
                i++;
            }

            if ((hours <= h) && (i == piles.length)) {
                right = mid - 1;
                ans = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return ans;

    }
}
