package n029.divide.two.integers;
/**
 * <p>29. Divide Two Integers
 * <p>Difficulty: Medium
 * <p>Divide two integers without using multiplication, division and mod operator.
 * <p>If it is overflow, return MAX_INT.
 *
 */
public class Solution {

	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			throw new ArithmeticException("/ by zero");
		}
		boolean sign = (dividend < 0) ^ (divisor < 0);
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		if (dividend == 0) {
			return 0;
		}
		if (dividend > 0) {
			dividend = -dividend;
		}
		if (divisor > 0) {
			divisor = -divisor;
		}
		if (dividend == divisor) {
			return sign ? -1 : 1;
		}
		if (divisor == -1) {
			return sign ? dividend : -dividend;
		}

		int x = divisor;
		int r = 1;
		while (dividend <= x && (Integer.MIN_VALUE >> 1) <= x) {
			x = x << 1;
			r = r << 1;
		}
		int result = 0;
		if (x >= dividend) {
			result = divide(dividend - x, divisor) + r;
			return sign ? -result : result;
		}
		// dividend is between x and x/2
		while (x < divisor) {
			x = x >> 1;
			r = r >> 1;
			if (x >= dividend) {
				dividend -= x;
				result += r;
			}
		}
		return sign ? -result : result;
	}

	public static void main(String[] args) {
		int x = Integer.MIN_VALUE + 1;
		int y = -1;
		System.out.println(new Solution().divide(x, y));
		System.out.println(x / y);
	}

}
