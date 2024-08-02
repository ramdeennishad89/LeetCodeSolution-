class Solution {
    public int minSwaps(int[] data) {
        int totalOnes = 0;
        for (int num : data) {
            if (num == 1) {
                totalOnes++;
            }
        }
        int maxOnesInWindow = 0, currentOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (data[i] == 1) {
                currentOnes++;
            }
        }
        maxOnesInWindow = currentOnes;
        for (int i = totalOnes; i < data.length + totalOnes; i++) {
            if (data[i % data.length] == 1) {
                currentOnes++;
            }
            if (data[(i - totalOnes) % data.length] == 1) {
                currentOnes--;
            }
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }
        return totalOnes - maxOnesInWindow;
    }
}