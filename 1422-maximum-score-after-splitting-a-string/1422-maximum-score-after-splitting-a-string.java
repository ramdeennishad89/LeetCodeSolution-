class Solution {
    public int maxScore(String s) {
         int maxScore = 0;
        int zeros = 0, ones = 0;

        // Count total number of ones
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        int currentOnes = 0;
        // Iterate through the string, except the last character
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') zeros++;
            else currentOnes++;

            int score = zeros + (ones - currentOnes);
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}