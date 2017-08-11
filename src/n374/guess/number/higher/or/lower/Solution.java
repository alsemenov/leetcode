package n374.guess.number.higher.or.lower;

/**
 * <p>374. Guess Number Higher or Lower</p>
 * <p>Difficulty:Easy</p>
 * <p>We are playing the Guess Game. The game is as follows:</p>
 * <p>I pick a number from 1 to n. You have to guess which number I picked.</p>
 * <p>Every time you guess wrong, I'll tell you whether the number is higher or lower.</p>
 * <p>You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):<br>

 -1 : My number is lower<br>
 1 : My number is higher<br>
 0 : Congrats! You got it!</p>
 <p>Example:
 n = 10, I pick 6.

 Return 6.</p>
 */
public class Solution extends GuessGame {

	public Solution(int x) {
		super(x);
	}

	public int guessNumber(int n) {
		int left = 1, right = n;
		while(true) {
			final int m = left+(right-left)/2;
			switch(guess(m)){
				case -1:
					right = m-1;
					break;
				case 0:
					return m;
				case 1:
					left = m+1;
					break;
			}
		}
	}

	public static void main(String[] args) {
//		for (int i=1; i<Integer.MAX_VALUE; i++) {
//			System.out.println(i);
//			for (int k=1; k<=i; k++) {
//				if (new Solution(k).guessNumber(i) != k) {
//					System.out.println("i: " + i + " k:" + k);
//				}
//			}
//		}
//		System.out.println(new Solution(1702766719).guessNumber(2126753390));
	}

}
