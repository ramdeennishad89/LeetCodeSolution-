class Solution {
    public int maximumSum(int[] nums) {
         HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int sumDigits = sumOfDigits(num);
            if (map.containsKey(sumDigits)) {
                maxSum = Math.max(maxSum, map.get(sumDigits) + num);
                map.put(sumDigits, Math.max(map.get(sumDigits), num));
            } else {
                map.put(sumDigits, num);
            }
        }

        return maxSum;
    }

    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}