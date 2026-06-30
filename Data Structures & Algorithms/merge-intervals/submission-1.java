class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = res.get(res.size() - 1);
            int[] next = intervals[i];
            if (curr[1] >= next[0]) {
                // curr[0] = Math.min(curr[0], next[0]);
                curr[1] = Math.max(curr[1], next[1]);
            }
            else {
                res.add(next);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
