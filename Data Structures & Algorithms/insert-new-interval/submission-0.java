class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = null;
                break;
            }
            else if(interval[1] < newInterval[0]) {
                res.add(interval);
            }
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if(newInterval != null ) {
            res.add(newInterval);
        }
        for (; i < intervals.length; i++) {
            res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][]);
        
    }
}
