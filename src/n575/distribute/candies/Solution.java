package n575.distribute.candies;

import java.util.HashSet;

/**
 * <p>575. Distribute Candies</p>
 * <p>Difficulty:Easy</p>
 * <p>Given an integer array with even length, where different numbers in this array represent different kinds of
 * candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in
 * number to brother and sister. Return the maximum number of kinds of candies the sister could gain.</p>

 <p>Example 1:<br>
 Input: candies = [1,1,2,2,3,3]<br>
 Output: 3<br>
 Explanation:<br>
 There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 The sister has three different kinds of candies.</p>
 <p>Example 2:<br>
 Input: candies = [1,1,2,3]<br>
 Output: 2<br>
 Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 The sister has two different kinds of candies, the brother has only one kind of candies.</p>
 <p>Note:

 The length of the given array is in range [2, 10,000], and will be even.
 The number in given array is in range [-100,000, 100,000].</p>
 */
public class Solution {
	public int distributeCandies(int[] candies) {
		HashSet<Integer> sisterSet = new HashSet<>();
		int max = candies.length/2;
		for (int i=0; i<candies.length && sisterSet.size()<max; i++) {
			sisterSet.add(candies[i]);
		}
		return sisterSet.size();
	}
}
