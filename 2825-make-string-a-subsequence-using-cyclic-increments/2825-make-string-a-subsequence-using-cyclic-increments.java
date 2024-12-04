class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
       int n = str1.length();  // Length of str1
    int m = str2.length();  // Length of str2
    int j = 0;  // Pointer for str2

    // Iterate through str1
    for (int i = 0; i < n && j < m; i++) {
        // Check if characters match or if there's a cyclic shift of one position
        if (str1.charAt(i) == str2.charAt(j) || 
            (str1.charAt(i) + 1 - 'a') % 26 + 'a' == str2.charAt(j)) {
            j++;  // Move to the next character in str2
        }
    }

    // Return true if we've matched all of str2
    return j == m;
    }
}