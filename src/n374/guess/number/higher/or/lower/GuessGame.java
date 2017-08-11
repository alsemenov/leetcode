package n374.guess.number.higher.or.lower;

public class GuessGame {
	private final int x;

	public GuessGame(int x) {
		this.x = x;
	}

	protected int guess(int m) {
		return Integer.compare(x,m);
	}

}
