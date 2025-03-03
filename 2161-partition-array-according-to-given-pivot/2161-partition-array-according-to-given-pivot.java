class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int index = 0;

        for (int num : nums) {
            if (num < pivot) {
                result[left++] = num;
            }
        }

        for (int num : nums) {
            if (num == pivot) {
                result[left++] = num;
            }
        }

        for (int num : nums) {
            if (num > pivot) {
                result[left++] = num;
            }
        }

        return result;
    }
}