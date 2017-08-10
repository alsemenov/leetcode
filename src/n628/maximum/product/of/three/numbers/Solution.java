package n628.maximum.product.of.three.numbers;

/**
 * <p>628. Maximum Product of Three Numbers</p>
 * <p>Difficulty:Easy</p>
 * <p>Given an integer array, find three numbers whose product is maximum and output the maximum product.</p>

 <p>Example 1:<br>
 Input: [1,2,3]<br>
 Output: 6</p>
 <p>Example 2:<br>
 Input: [1,2,3,4]<br>
 Output: 24<br></p>
 <p>Note:<ol>
 <li>The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].</li>
 <li>Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.</li>
 </ol></p>
 */
public class Solution {
	public int maximumProduct(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1;
		int min1 = Integer.MAX_VALUE, min2 = min1;
		for (int i: nums){
			if (i>max1){
				max3 = max2;
				max2 = max1;
				max1 = i;
			} else if (i>max2){
				max3 = max2;
				max2 = i;
			} else if (i>max3){
				max3 = i;
			}
			if (i<min1){
				min2 = min1;
				min1 = i;
			} else if (i<min2){
				min2 = i;
			}
		}
		return Math.max(max1*max2*max3, max1*min1*min2);
	}
}
