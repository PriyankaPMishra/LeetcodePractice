class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;
        int diff = 0;
        int leftQ = 0;
        int rightQ = 0;

        // First half
        // Calculate the sum of known digits and count '?' characters
        for (int i = 0; i < half; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                diff += num.charAt(i) - '0';
            }
        }

        // Second half
        // Subtract the sum of known digits and count '?' characters
        for (int i = half; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                diff -= num.charAt(i) - '0';
            }
        }

        // Bob wins only if the existing difference can be
        // exactly balanced by the '?' characters.
        // Each unmatched '?' can contribute a difference of 9.
        // The factor 2 accounts for the fact that the '?' characters
        // are chosen alternately by Alice and Bob.
        return 2 * diff != 9 * (rightQ - leftQ);
    }
}