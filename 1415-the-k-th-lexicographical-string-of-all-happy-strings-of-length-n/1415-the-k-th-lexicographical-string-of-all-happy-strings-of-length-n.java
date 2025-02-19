class Solution {
     private int count = 0;
    private String result = "";
    public String getHappyString(int n, int k) {
        backtrack(n, k, new StringBuilder(), ' ');
        return result;
    }

    private void backtrack(int n, int k, StringBuilder sb, char lastChar) {
        if (sb.length() == n) {
            count++;
            if (count == k) {
                result = sb.toString();
            }
            return;
        }

        for (char c : new char[]{'a', 'b', 'c'}) {
            if (c != lastChar) {
                sb.append(c);
                backtrack(n, k, sb, c);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}