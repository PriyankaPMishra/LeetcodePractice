class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j] = maximum stones the current player can get from piles[i..j]
        int[][] dp = new int[n][n];
        
        // Base case: one pile
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        
        // Fill for longer intervals
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                // Current player takes left or right
                dp[i][j] = Math.max(
                    piles[i] - dp[i + 1][j],
                    piles[j] - dp[i][j - 1]
                );
            }
        }
        
        return dp[0][n - 1] > 0;
    }
}