package n215.kth.largest.element.in.an.array;

import java.util.PriorityQueue;

/**
<p>215. Kth Largest Element in an Array
<p>Difficulty: Medium
<p>Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

<p>For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

<p>Note: 
You may assume k is always valid, 1 =< k <= array's length.
 *
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int n: nums){
            pq.offer(n);
            if (pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
