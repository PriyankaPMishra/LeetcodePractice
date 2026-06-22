class Solution {
    public int countCharacters(String[] words, String chars) {

        int[] charsFreq = new int[26];

        for (char c : chars.toCharArray()) {
            charsFreq[c - 'a']++;
        }

        int answer = 0;

        for (String word : words) {

            int[] wordFreq = new int[26];

            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }

            boolean isGood = true;

            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] > charsFreq[i]) {
                    isGood = false;
                    break;
                }
            }

            if (isGood) {
                answer += word.length();
            }
        }

        return answer;
    }
}