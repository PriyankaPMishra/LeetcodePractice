class Solution {
    public boolean predictTheWinner(int[] nums) {
        return dfs(0, nums.length - 1, 0, 0, true, nums);
    }

    public static boolean dfs(int left, int right, int player1, int player2, boolean turn, int[] nums) {
        if (left > right)
            return player1 >= player2; 

        if (turn) {
            return dfs(left + 1, right, player1 + nums[left], player2, false, nums) ||
                   dfs(left, right - 1, player1 + nums[right], player2, false, nums);
        } 
        else {
            return dfs(left + 1, right, player1, player2 + nums[left], true, nums) &&
                   dfs(left, right - 1, player1, player2 + nums[right], true, nums);
        }
    }
}