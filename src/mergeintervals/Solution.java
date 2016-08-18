package mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * <p>Given a collection of intervals, merge all overlapping intervals.

<p>For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 *
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval i1, Interval i2){
                    if (i1.start<i2.start){
                        return -1;
                    } else if (i1.start==i2.start){
                        return 0;
                    }
                    return 1;
                }
            });
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval last = null;
        for (Interval i: intervals){
            if (last==null || i.start>last.end) {
                result.add(i);
                last = i;
            } else {
                last.end = Math.max(last.end, i.end);
            }
        }
        return result;       
    }
}
