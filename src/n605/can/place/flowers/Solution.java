package n605.can.place.flowers;

/**
 * <p>605. Can Place Flowers</p>
 * <p>Difficulty:Easy</p>
 * <p>Suppose you have a long flowerbed in which some of the plots are planted and some are not.
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.</p>
 * <p>Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
 * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.</p>

 <p>Example 1:<br>
 Input: flowerbed = [1,0,0,0,1], n = 1<br>
 Output: True<br>
 Example 2:<br>
 Input: flowerbed = [1,0,0,0,1], n = 2<br>
 Output: False</p>
 <p>Note:<ol>
 <li>The input array won't violate no-adjacent-flowers rule.</li>
 <li>The input array size is in the range of [1, 20000].</li>
 <li>n is a non-negative integer which won't exceed the input array size.</li></ol></p>
 */
public class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		int left = 0;
		for (int i=0; i<flowerbed.length; i++) {
			int v = flowerbed[i];
			int right = i+1<flowerbed.length ? flowerbed[i+1] : 0;

			if (left==0 && v==0 && right==0){
				count++;
				left = 1;
			} else {
				left = v;
			}
		}
		return n<=count;
	}
}
