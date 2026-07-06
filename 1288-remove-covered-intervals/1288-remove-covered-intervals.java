class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        // Sort by:
        // 1. Start in ascending order.
        // 2. If starts are equal, end in descending order.
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        int count = 0;
        int maxEnd = 0;

        for (int[] interval : intervals) {

            // If current interval extends beyond every interval seen so far,
            // it cannot be covered.
            if (interval[1] > maxEnd) {
                count++;
                maxEnd = interval[1];
            }
            // Else:
            // interval[1] <= maxEnd
            // Since its start is also >= a previous interval's start
            // (because of sorting), it is covered.
        }

        return count;
    }
}