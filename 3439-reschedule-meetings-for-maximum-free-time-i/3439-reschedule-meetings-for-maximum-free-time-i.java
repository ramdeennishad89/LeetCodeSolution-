class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        List<Integer> gaps = new ArrayList<>();

        // calculating gaps
        gaps.add(startTime[0]);
        for (int i = 1; i < n; i++) {
            gaps.add(startTime[i] - endTime[i - 1]);
        }
        gaps.add(eventTime - endTime[n - 1]);

        int currentSum = 0, res = 0;

        // use sliding window on gaps array to find maximum possible gap
        // for K meetings there K+1 gaps, thus window size = K+1

        for (int i = 0; i < gaps.size(); ++i) {

            // form window of size k+1
            // if i >= k+1, add new element and remove i-(k+1) element
            currentSum += gaps.get(i) - ((i >= k + 1) ? gaps.get(i - (k + 1)) : 0);
            res = Math.max(res, currentSum);
        }

        return res;

    }
}