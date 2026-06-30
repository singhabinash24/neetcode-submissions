class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 1;
        int curr[] = intervals[0];
        int count = 0;
        for (; i < intervals.length; i++) {
            int next[] = intervals[i];
            if (curr[1] > next[0]) {
                count++;
                curr = next[1] > curr[1] ? curr : next;
            } else {
                curr = next;
            }
        }
        return count;
    }
}
