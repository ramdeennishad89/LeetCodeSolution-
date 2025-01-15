class Solution {
    public int minimizeXor(int x, int c) {
        int countC = Integer.bitCount(c);
        int result = 0;
        for (int i = 31; i >= 0 && countC > 0; i--) {
            if ((x & (1 << i)) != 0) {
                result |= (1 << i);
                countC--;
            }
        }
        for (int i = 0; i < 32 && countC > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i);
                countC--;
            }
        }
        return result;

    }
}