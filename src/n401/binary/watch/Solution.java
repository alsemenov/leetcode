package n401.binary.watch;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>401. Binary Watch</p>
 * <p>Difficulty:Easy</p>
 * <p>A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).</p>
 * <p>Each LED represents a zero or one, with the least significant bit on the right.</p>
 * <p>For example, the above binary watch reads "3:25".</p>
 * <p>Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.</p>

 <p>Example:<br>

 Input: n = 1<br>
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]</p>
 <p>Note:<ol>
 <li>The order of output does not matter.</li>
 <li>The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".</li>
 <li>The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".</li></ol></p>
 */
public class Solution {
	public List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<>();
		for (int i=0; i<1024; i++){
			if (countBits(i)==num){
				int h = (i>>6) & 0xf;
				int m = i & 0x3f;
				if (h>=0 && h<=11 && m>=0 && m<=59){
					result.add(""+h+":"+(m<10?"0":"")+m);
				}
			}
		}
		return result;
	}

	private int countBits(int x) {
		int count = 0;
		while (x!=0){
			x = x & (x-1);
			count++;
		}
		return count;
	}
}
