class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        for (int start = 0; start < n; start++) {
            int targetCount = 0;

            for (int end = start; end < n; end++) {

                if (nums[end] == target) {
                    targetCount++;
                }

                int length = end - start + 1;

                if (2 * targetCount > length) {
                    count++;
                }
            }
        }

        return count;
    }
}