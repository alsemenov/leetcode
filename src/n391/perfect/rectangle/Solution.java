package n391.perfect.rectangle;
import java.util.*;
/**
 * <p>391. Perfect Rectangle</p>
 * <p>Difficulty: Hard</p>
 * <p>Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
 * <p>Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
 *
 */
public class Solution {
	/*
	 * The solution is based on idea:
	 * the area of covered rectangle and the sum of areas of all rectangles are the same,
	 * unless rectangles overlap. If rectangles overlap, the sum will be greater. If the are gaps,
	 * the sum will be smaller. If there are gaps and intersections the sum can be any value.
	 * So we need to make sure that rectangles do not overlap.
	 * First step - calculate and compare areas.
	 * Second step - check that rectangles do not overlap.    
	 */
	public boolean isRectangleCover(int[][] rectangles) {
		if (rectangles.length==0){
			return false;
		}
		int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
		int square = 0;
        
        SortedMap<Integer,Deque<int[]>> xMap = new TreeMap<Integer,Deque<int[]>>();
		for (int[] rectangle: rectangles){
			minX = Math.min(minX, rectangle[0]);
			minY = Math.min(minY, rectangle[1]);
			maxX = Math.max(maxX, rectangle[2]);
			maxY = Math.max(maxY, rectangle[3]);

            xMap.computeIfAbsent(rectangle[0], k->new ArrayDeque<int[]>()).addLast(rectangle);
            xMap.computeIfAbsent(rectangle[2], k->new ArrayDeque<int[]>()).addFirst(rectangle);
            
			square += (rectangle[2]-rectangle[0]) * (rectangle[3]-rectangle[1]);
		}

		int wholeSquare = (maxX - minX) * (maxY - minY);

		if (wholeSquare != square){
			return false;
		};
        
        // check if rectangles overlap
        SortedSet<int[]> ySet = new TreeSet<int[]>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if (o1[3]<=o2[1]){
                    return -1;
                } else if (o2[3]<=o1[1]){
                    return 1;
                }
                return 0;
            }
        });
        for (Map.Entry<Integer,Deque<int[]>> me: xMap.entrySet()){
            int x = me.getKey();
            for(int[] r: me.getValue()){
                if (x==r[2]){
                    ySet.remove(r);
                } else if (!ySet.add(r)){
                    return false;
                }
            }    
        }
		return true;
	}
}
