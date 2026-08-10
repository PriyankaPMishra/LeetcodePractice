
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int remaining = i - j * j;

                if (!dp[remaining]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}

/*
 * Why is this a 1D DP problem?
 *
 * dp[i] represents whether the current player can win when there
 * are exactly i stones remaining.
 *
 * For every i, we try removing every possible perfect square:
 *
 *      1, 4, 9, 16, ...
 *
 * Suppose we remove j * j stones from i.
 *
 * The opponent is then left with:
 *
 *      remaining = i - j * j
 *
 * If dp[remaining] is false, it means the opponent is in a losing
 * position. Therefore, the current player can make a winning move.
 *
 * So:
 *
 *      dp[i] = true
 *
 * if there exists at least one square j * j such that:
 *
 *      dp[i - j * j] == false
 *
 * Otherwise, dp[i] remains false.
 *
 * Base Case:
 *
 *      dp[0] = false
 *
 * There are no stones left, so the player whose turn it is cannot
 * make a move and loses.
 *
 * Example:
 *
 *      n = 4
 *
 * We can remove 4:
 *
 *      4 -> 0
 *
 * Since dp[0] = false, dp[4] = true.
 *
 * Therefore, the first player wins.
 *
 * Time Complexity:
 *      O(n * sqrt(n))
 *
 * For every i from 1 to n, we try all perfect squares <= i.
 *
 * Space Complexity:
 *      O(n)
 *
 * We use a boolean DP array of size n + 1.
 */