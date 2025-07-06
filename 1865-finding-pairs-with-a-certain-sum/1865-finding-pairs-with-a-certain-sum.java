class FindSumPairs {

    private int[] arr1;
    private int[] arr2;
    private Map<Integer, Integer> freq2;

    public FindSumPairs(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.freq2 = new HashMap<>();
        for (int n : arr2) {
            freq2.put(n, freq2.getOrDefault(n, 0) + 1);
        }
    }

    public void add(int idx, int val) {
        int oldVal = arr2[idx];
        freq2.put(oldVal, freq2.get(oldVal) - 1);
        int newVal = oldVal + val;
        freq2.put(newVal, freq2.getOrDefault(newVal, 0) + 1);
        arr2[idx] = newVal;
    }

    public int count(int tgt) {
        int total = 0;
        for (int n : arr1) {
            int diff = tgt - n;
            total += freq2.getOrDefault(diff, 0);
        }
        return total;
    }
}