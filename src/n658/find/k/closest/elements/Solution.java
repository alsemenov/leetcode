package n658.find.k.closest.elements;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
/**
 * <p>658. Find K Closest Elements</p>
 * <p>Difficulty: Medium</p>
 * <p>Given a sorted array, two integers k and x, find the k closest elements to x in the array. 
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.</p>

<p>Example 1:<br>
Input: [1,2,3,4,5], k=4, x=3<br>
Output: [1,2,3,4]</p>
<p>Example 2:<br>
Input: [1,2,3,4,5], k=4, x=-1<br>
Output: [1,2,3,4]</p>
<p>Note:<ol>
<li>The value k is positive and will always be smaller than the length of the sorted array.
<li>Length of the given array is positive and will not exceed 104
<li>Absolute value of elements in the array and x will not exceed 104</ol></p>
 *
 */
public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int i = Collections.binarySearch(arr, x);
        int left, right;
        if (i<0){
            right = -i - 1;            
        } else {
            right = i;            
        }
        left = right - 1;
        Deque<Integer> result = new ArrayDeque<>();
        while (k>0){
            if (left>=0 && right<arr.size()){
                if (Math.abs(arr.get(left)-x)<=Math.abs(arr.get(right)-x)){
                    result.addFirst(arr.get(left));
                    left--;
                } else {
                    result.addLast(arr.get(right));
                    right++;
                }
            } else if (left>=0) {
                result.addFirst(arr.get(left));
                left--;
            } else if (right<arr.size()){
                result.addLast(arr.get(right));
                right++;
            } else {
                throw new RuntimeException("k is greater than arr.size()");
            }
            k--;
        }
        return new ArrayList<Integer>(result);
    }
}
