package n400.nth.digit;

/**
 * <p>400. Nth Digit</p>
 * <p>Difficulty:Easy</p>
 * <p>Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...</p>
 * <p>Note: n is positive and will fit within the range of a 32-bit signed integer (n < 231).</p>
 * <p>Example 1:<br>

 Input:<br>
 3<br>

 Output:<br>
 3</p>
 <p>Example 2:<br>

 Input:<br>
 11<br>

 Output:<br>
 0<br>

 Explanation:
 The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.</p>
 */
public class Solution {
	public int findNthDigit(int n) {
		if (n<=9){
			return n;
		}
		// find number that gives digits for n
		n -=10;
		int i = 2;
		long base = 10;
		long limit = i * 9 * base;
		while (n>=limit){
			n -= i * 9 * base;
			base = base*10;
			i++;
			limit = i * 9 * base;
		}
		// find digit inside the number
		long x = base + n/i;
		int k = i-(n%i);
		int digit = 0;
		while (k>0){
			digit = (int)(x%10);
			x = x/10;
			k--;
		}
		return digit;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(new Solution().findNthDigit(Integer.MAX_VALUE));
	}
}
