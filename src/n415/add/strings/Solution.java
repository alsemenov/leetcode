package n415.add.strings;

/**
 * <p>415. Add Strings</p>
 * <p>Difficulty:Easy</p>
 * <p>Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.</p>

 <p>Note:<ol>

 <li>The length of both num1 and num2 is < 5100.</li>
 <li>Both num1 and num2 contains only digits 0-9.</li>
 <li>Both num1 and num2 does not contain any leading zero.</li>
 <li>You must not use any built-in BigInteger library or convert the inputs to integer directly.</li></ol></p>
 */
public class Solution {
	public String addStrings(String num1, String num2) {
		final int len1 = num1.length(), len2 = num2.length();
		final int len = Math.max(len1, len2);
		final StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i=1; i<=len; i++){
			final int d1 = (len1-i)>=0? num1.charAt(len1-i)-'0': 0;
			final int d2 = (len2-i)>=0? num2.charAt(len2-i)-'0': 0;
			final int r = d1 + d2 + carry;
			sb.append((char)('0'+r%10));
			carry = r/10;
		}
		if (carry>0){
			sb.append((char)('0'+carry));
		}
		sb.reverse();
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().addStrings("12345","999999"));
	}
}
