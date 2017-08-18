package n405.convert.a.number.to.hexadecimal;

/**
 * <p>405. Convert a Number to Hexadecimal</p>
 * <p>Difficulty:Easy</p>
 * <p>Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.</p>
 * <p>Note:
<ol>
 <li>All letters in hexadecimal (a-f) must be in lowercase.</li>
 <li>The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single
 zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.</li>
 <li>The given number is guaranteed to fit within the range of a 32-bit signed integer.</li>
 <li>You must not use any method provided by the library which converts/formats the number to hex directly.</li></ol>
 </p>
 <p>Example 1:<br>

 Input:<br>
 26<br>

 Output:<br>
 "1a"</p>
 <p>Example 2:<br>

 Input:<br>
 -1<br>

 Output:<br>
 "ffffffff"</p>
 */
public class Solution {
	public String toHex(int num) {
		if (num==0){
			return "0";
		}
		char[] result = new char[8];
		int i = 8;
		while (num!=0){
			i--;
			final int d0 = num & 0xf;
			result[i] = (char)(d0>=10 ? d0 - 10 + 'a' : d0 +'0');
			num = num>>>4;
		}
		return new String(result, i, 8-i);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().toHex(-1));
		System.out.println(new Solution().toHex(0));
		System.out.println(new Solution().toHex(256));
	}
}
