class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minRecolors = Integer.MAX_VALUE;
        int whiteCount = 0;

        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }

            if (i >= k - 1) {
                minRecolors = Math.min(minRecolors, whiteCount);
                if (blocks.charAt(i - k + 1) == 'W') {
                    whiteCount--;
                }
            }
        }
        return minRecolors;
    }
}