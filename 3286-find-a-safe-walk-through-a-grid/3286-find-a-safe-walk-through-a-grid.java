class Solution {

    // Four possible directions: Right, Left, Down, Up
    public static final int[][] DIR = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        // bestHealth[r][c] stores the maximum remaining health with which we have reached cell (r, c).
        int[][] bestHealth = new int[n][m];

        // -1 means the cell has not been visited yet.
        for (int[] row : bestHealth) {
            Arrays.fill(row, -1);
        }

        // Max Heap; element = {row, col, remainingHealth}
        // Process the path with the highest remaining health first.
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[2] - a[2]
        );

        // Lose 1 health if the starting cell is unsafe.
        int startHealth = health - grid.get(0).get(0);

        if (startHealth <= 0)
            return false;

        pq.offer(new int[]{0, 0, startHealth});
        bestHealth[0][0] = startHealth;

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int r = cur[0];
            int c = cur[1];
            int h = cur[2];

            // Reached destination with positive health.
            if (r == n - 1 && c == m - 1)
                return true;

            // Ignore this state if we have already reached this cell earlier with more remaining health.
            if (h < bestHealth[r][c])
                continue;

            // Explore all four neighboring cells.
            for (int[] d : DIR) {

                int nr = r + d[0];
                int nc = c + d[1];

                // Skip cells outside the grid.
                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                // Lose 1 health if the next cell is unsafe.
                int nextHealth = h - grid.get(nr).get(nc);

                // Cannot move if health becomes zero or negative.
                if (nextHealth <= 0)
                    continue;

                // Only continue if this path reaches the neighbor with more remaining health than before.
                if (nextHealth > bestHealth[nr][nc]) {

                    bestHealth[nr][nc] = nextHealth;

                    pq.offer(new int[]{
                        nr,
                        nc,
                        nextHealth
                    });
                }
            }
        }

        return false;
    }
}