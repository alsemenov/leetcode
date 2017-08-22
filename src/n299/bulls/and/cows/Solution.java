package n299.bulls.and.cows;

/**
 * <p>299. Bulls and Cows</p>
 * <p>Difficulty:Medium</p>
 * <p>You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend
 * to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits
 * in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits
 * match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses
 * and hints to eventually derive the secret number.</p>

 <p>For example:

 Secret number:  "1807"<br>
 Friend's guess: "7810"<br>
 Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)</p>
 <p>Write a function to return a hint according to the secret number and friend's guess,
 use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".</p>

 <p>Please note that both secret number and friend's guess may contain duplicate digits, for example:<br>

 Secret number:  "1123"<br>
 Friend's guess: "0111"<br>
 In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.</p>
 */
public class Solution {
	public String getHint(String secret, String guess) {
		int bulls = 0;
		final int[] count = new int[10];
		final int len = secret.length();
		for (int i=0; i<len; i++) {
			final char c = secret.charAt(i);
			if (c==guess.charAt(i)){
				bulls++;
			} else {
				count[c-'0']++;
			}
		}
		int cows = 0;
		for (int i=0; i<len; i++){
			final char c = guess.charAt(i);
			if (secret.charAt(i)!=c){
				if (count[c-'0']>0){
					cows++;
					count[c-'0']--;
				}
			}
		}
		return bulls+"A"+cows+"B";
	}
}
