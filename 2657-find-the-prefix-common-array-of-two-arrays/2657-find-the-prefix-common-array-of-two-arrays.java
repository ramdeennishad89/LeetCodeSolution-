class Solution {
    public int[] findThePrefixCommonArray(int[] arr1, int[] arr2) {
         int n = arr1.length;
        int[] result = new int[n];
        HashSet<Integer> set = new HashSet<>();
        int commonCount = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(arr1[i])) {
                commonCount++;
            } else {
                set.add(arr1[i]);
            }
            if (set.contains(arr2[i])) {
                commonCount++;
            } else {
                set.add(arr2[i]);
            }
            result[i] = commonCount;
        }
        return result;
    }
}