class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26]; // Frequency count of each character
        boolean[] visited = new boolean[26]; // To check if a character is in the stack
        Stack<Character> stack = new Stack<>();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            freq[c - 'a']--; // Decrease frequency as we process the character

            // Skip if the character is already in the stack
            if (visited[c - 'a']) {
                continue;
            }

            // Remove characters from the stack if they:
            // 1. Are greater than the current character
            // 2. Can appear later in the string
            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            // Push the current character onto the stack
            stack.push(c);
            visited[c - 'a'] = true;
        }

        // Convert stack to a string
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}