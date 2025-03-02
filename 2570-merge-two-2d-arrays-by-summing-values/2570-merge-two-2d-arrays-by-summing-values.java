class Solution {
    public int[][] mergeArrays(int[][] arr1, int[][] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : arr1) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }
        for (int[] pair : arr2) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }
        int[][] result = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index++] = new int[]{entry.getKey(), entry.getValue()};
        }
        Arrays.sort(result, Comparator.comparingInt(a -> a[0]));
        return result;
    }
}