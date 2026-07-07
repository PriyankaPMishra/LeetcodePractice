class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int dig = ch - '0';
            sum += dig;
            if (dig > 0) {
                x = x * 10 + dig;
            }
        }
        return x * sum;
    }
}