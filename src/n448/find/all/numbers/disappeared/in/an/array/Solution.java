package n448.find.all.numbers.disappeared.in.an.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>448. Find All Numbers Disappeared in an Array</p>
 * <p> Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.</p>
 * <p>Find all the elements of [1, n] inclusive that do not appear in this array.</p>
 * <p>Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.</p>

 <p>Example:<br>

 Input:<br>
 [4,3,2,7,8,2,3,1]<br>

 Output:<br>
 [5,6]</p>
 */
public class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		boolean finish = true;
		do {
			finish = true;
			for(int i=0; i<nums.length; i++){
				final int k = nums[i];
				if (k-1!=i && k!=0){ // not (in place or no-value)
					finish = false;
					nums[i] = (nums[k-1]==k) ? 0: nums[k-1];
					nums[k-1] = k;
				}

			}
		} while (!finish);
		final List<Integer> result =  new ArrayList<>();
		for (int i=0; i<nums.length; i++){
			if (nums[i]==0){
				result.add(i+1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = {4,3,2,7,8,2,3,1};
		System.out.println(new Solution().findDisappearedNumbers(input));
	}

}
