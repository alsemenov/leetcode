package reversewordsinastring;
/**
 * <p>151. Reverse Words in a String
 * <p>Given an input string, reverse the string word by word.

<p>For example,
<p>Given s = "the sky is blue",
return "blue is sky the".

<p>Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

<p>Clarification:
<ul>
<li>What constitutes a word?<br>
A sequence of non-space characters constitutes a word.
<li>Could the input string contain leading or trailing spaces?<br>
Yes. However, your reversed string should not contain leading or trailing spaces.
<li>How about multiple spaces between two words?<br>
Reduce them to a single space in the reversed string.
</ul>
 *
 */
public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        int i = len-1;
        while (i>=0){
            // skip trailing spaces
            while(i>=0 && s.charAt(i)==' ') {
                i--;
            }
            // find the start position of the word
            int wf = i;
            while(i>=0 && s.charAt(i)!=' ') {
                i--;
            }
            // copy word to sb
            if (i<wf){
                for(int k=i+1; k<=wf; k++){
                    sb.append(s.charAt(k));
                }
                sb.append(' ');
            }
        }
        if (sb.length()>0) {
            sb.setLength(sb.length()-1);
        }
        return sb.toString();  
    }
    
	public static void main(String[] args) {
		System.out.println(new Solution().reverseWords("   abc   bcd "));
	}

}
