package n412.fizz.buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>412. Fizz Buzz</p>
 * <p>Difficulty:Easy</p>
 * <p>Write a program that outputs the string representation of numbers from 1 to n.</p>
 * <p>But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.</p>

 <p>Example:
<pre>
 n = 15,

 Return:
 [
 "1",
 "2",
 "Fizz",
 "4",
 "Buzz",
 "Fizz",
 "7",
 "8",
 "Fizz",
 "Buzz",
 "11",
 "Fizz",
 "13",
 "14",
 "FizzBuzz"
 ]
 </pre>
 </p>
 */
public class Solution {
	public List<String> fizzBuzz(int n) {
		final List<String> result = new ArrayList<>();
		for (int i=1; i<=n; i++){
			 final int r3 = i%3;
			 final int r5 = i%5;
			if (r3==0 && r5==0){
				result.add("FizzBuzz");
			} else if (r3==0) {
				result.add("Fizz");
			} else if (r5==0) {
				result.add("Buzz");
			} else {
				result.add(Integer.toString(i));
			}
		}
		return result;
	}
}
