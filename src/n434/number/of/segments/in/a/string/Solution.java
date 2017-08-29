package n434.number.of.segments.in.a.string;

/**
 * <p>434. Number of Segments in a String</p>
 * <p>Difficulty:Easy</p>
 * <p>Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.</p>

 <p>Please note that the string does not contain any non-printable characters.</p>

 <p>Example:<br>

 Input: "Hello, my name is John"<br>
 Output: 5</p>
 */
public class Solution {
	public int countSegments(String s) {
		int count = 0;
		final int len = s.length();
		int i =0;
		while (i<len){
			// skip for spaces
			while (i<len && Character.isSpaceChar(s.charAt(i))){
				i++;
			}
			// skip word
			if (i<len){
				count++;
				while (i<len && !Character.isSpaceChar(s.charAt(i))){
					i++;
				}
			}
		}
		return count;
	}
}
