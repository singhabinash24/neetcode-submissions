/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        Queue<Integer> meanHeap = new PriorityQueue<>();
        meanHeap.offer(intervals.get(0).end);
        int count = 1;
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            Integer prev = meanHeap.peek();
            if (prev > curr.start) {
                count++;
                meanHeap.offer(curr.end);
            } else {
                meanHeap.poll();
                meanHeap.offer(curr.end);
            }
        }
        return count;
    }
}
