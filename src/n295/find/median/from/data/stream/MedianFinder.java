package n295.find.median.from.data.stream;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>295. Find Median from Data Stream</p>
 * <p>Difficulty:Hard</p>
 * <p>Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.</p>
 * <p>Examples:<br>
 *     [2,3,4] , the median is 3<br>
 *     [2,3], the median is (2 + 3) / 2 = 2.5</p>
 * <p>Design a data structure that supports the following two operations:<ul>
 *     <li>void addNum(int num) - Add a integer number from the data stream to the data structure.</li>
 *     <li>double findMedian() - Return the median of all elements so far.</li></ul>
 * <p>For example:<pre>
 *     addNum(1)
 *     addNum(2)
 *     findMedian() -> 1.5
 *     addNum(3)
 *     findMedian() -> 2
 *     </pre></p>
 */
public class MedianFinder {

	private int count = 0;
	private final PriorityQueue<Integer> left, right;
	private double median = 0.0;

	/** initialize your data structure here. */
	public MedianFinder() {
		left = new PriorityQueue<>(Comparator.<Integer>reverseOrder());
		right = new PriorityQueue<>(Comparator.<Integer>naturalOrder());
	}

	public void addNum(int num) {
		PriorityQueue<Integer> l,r;
		if (num<median) {
			l = left;
			r = right;
		} else {
			l = right;
			r = left;
		}
		l.add(num);
		if ((count&1)==0){
			median = l.poll();
		} else {
			r.add((int)median);
			median = ((double)l.peek()+r.peek())/2;
		}
		count++;
	}

	public double findMedian() {
		if (count==0){
			throw new RuntimeException("no data");
		}
		return median;
	}
}
