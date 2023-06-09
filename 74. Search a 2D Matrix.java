// Medium. Binary Search.
// June 9 2023.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int row = (int) Math.floor(mid/matrix[0].length);
            int col = mid % matrix[0].length;

            int midVal = matrix[row][col];
            if (midVal < target) {
                l = mid + 1;
            }
            else if (midVal > target) {
                r = mid - 1;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
