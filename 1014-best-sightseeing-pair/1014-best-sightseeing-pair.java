class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = 0;
        int maxI = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            maxScore = Math.max(maxScore, maxI + A[j] - j);
            maxI = Math.max(maxI, A[j] + j);
        }
        return maxScore;
    }
}