class Solution {

    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for (int n : nums) {
            st.add(n);
            mini = Math.min(mini, n);
            maxi = Math.max(maxi, n);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = mini + 1; i < maxi; i++) {
            if (!st.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}