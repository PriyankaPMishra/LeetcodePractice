class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int idxA = -1;
        int idxB = -1;
        int idxC = -1;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a') idxA = i;
            else if(s.charAt(i) == 'b') idxB = i;
            else idxC = i;
            if(idxA == -1 || idxB == -1 || idxC == -1) continue;
            int min = Math.min(idxA, Math.min(idxB, idxC));
            count += min + 1;
        }
        return count;
    }
}