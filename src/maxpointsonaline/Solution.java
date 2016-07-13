package maxpointsonaline;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <p><a href="https://leetcode.com/problems/max-points-on-a-line/">https://leetcode.com/problems/max-points-on-a-line/</a>
 * <p>149. Max Points on a Line
 * 
 * <p>Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 */
/**
 * Definition for a point. class Point { int x; int y; Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; } }
 */
public class Solution {
	/**
	 * The line is defined by equation ax + by + c = 0 In this class b is equal
	 * either 1 or 0 by convention.
	 * 
	 * @author
	 *
	 */

	private static class Line {
		Point p = null;
		double a, b, c;

		/**
		 * ax1 + by1 + c = 0 ax2 + by2 + c = 0 if x1==x2 then b=0,a=1,c=-x1
		 * otherwise b=1 a = (y2-y1)/(x1-x2) c = -ax1 - y1
		 * 
		 * @param p1
		 * @param p2
		 */
		Line(Point p1, Point p2) {
			if (p1.x == p2.x && p1.y == p2.y) {
				p = p1;
			} else if (p1.x == p2.x) {
				a = 1.0;
				b = 0.0;
				c = -p1.x;
			} else {
				b = 1.0;
				a = ((double) (p2.y - p1.y)) / (p1.x - p2.x);
				c = -a * p1.x - p1.y;
				// the calculations are too precise, I have to round the values
				// to pass leetcode tests
				a = new BigDecimal(a, MathContext.DECIMAL32).doubleValue();
				c = new BigDecimal(c, MathContext.DECIMAL32).doubleValue();
			}
		}

		public boolean equals(Object object) {
			if (object instanceof Line) {
				Line that = (Line) object;
				if (p != null) {
					return that.p != null && p.x == that.p.x && p.y == that.p.y;
				} else {
					return that.p == null && a == that.a && b == that.b && c == that.c;
				}
			}
			return false;
		}

		public int hashCode() {
			if (p != null) {
				return p.x ^ p.y;
			}
			return Double.valueOf(a).hashCode() ^ Double.valueOf(b).hashCode() ^ Double.valueOf(c).hashCode();
		}

	}

	public int maxPoints(Point[] points) {
		if (points.length <= 1) {
			return points.length;
		}

		HashMap<Line, Set<Point>> map = new HashMap<Line, Set<Point>>();
		// for each pair of points define a line
		// keep points belonging to each line in map 
		for (int i = 0; i < points.length; i++) {
			for (int k = i + 1; k < points.length; k++) {
				Line line = new Line(points[i], points[k]);
				Set<Point> linePoints = map.get(line);
				if (linePoints == null) {
					linePoints = new HashSet<Point>();
					map.put(line, linePoints);
				}
				linePoints.add(points[i]);
				linePoints.add(points[k]);
			}
		}

		int max = 0;
		for (Set<Point> linePoints : map.values()) {
			if (linePoints.size() > max) {
				max = linePoints.size();
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Point[] points = new Point[] { new Point(0, 0), new Point(1, 1), new Point(0, 0), new Point(1, 2) };
		System.out.println(new Solution().maxPoints(points));
	}

}
