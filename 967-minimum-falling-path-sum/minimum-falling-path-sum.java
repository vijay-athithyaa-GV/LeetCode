import java.util.*;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        // Try every cell in the last row
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, findPath(n - 1, j, matrix, dp));
        }

        return ans;
    }

    public int findPath(int i, int j, int[][] matrix, int[][] dp) {

        int m = matrix[0].length;

        // Invalid column
        if (j < 0 || j >= m) {
            return Integer.MAX_VALUE;
        }

        // Reached first row
        if (i == 0) {
            return matrix[0][j];
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int up = findPath(i - 1, j, matrix, dp);
        int leftDiag = findPath(i - 1, j - 1, matrix, dp);
        int rightDiag = findPath(i - 1, j + 1, matrix, dp);

        int minPrev = Math.min(up, Math.min(leftDiag, rightDiag));

        // If all previous paths are invalid
        if (minPrev == Integer.MAX_VALUE) {
            return dp[i][j] = Integer.MAX_VALUE;
        }

        return dp[i][j] = matrix[i][j] + minPrev;
    }
}