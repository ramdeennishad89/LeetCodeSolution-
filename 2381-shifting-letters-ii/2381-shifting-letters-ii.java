class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
     int n = s.length();
        int[] diff = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            int increment = direction == 1 ? 1 : -1;
            diff[start] += increment;
            diff[end + 1] -= increment;
        }

        int shift = 0;
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            shift += diff[i];
            int newChar = (result[i] - 'a' + shift) % 26;
            if (newChar < 0) newChar += 26;
            result[i] = (char) ('a' + newChar);
        }
        return new String(result);
    }
}