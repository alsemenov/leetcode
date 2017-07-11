package n204.count.primes;

/**
 * <p>204. Count Primes</p>
 * <p>Difficulty: Easy</p>
 * <p>Count the number of prime numbers less than a non-negative number, n.</p>
 */
public class Solution {
	// use array of boolean
	public int countPrimes1(int n) {
		boolean[] x = new boolean[n];
		int count = 0;
		for (int i=2; i<n; i++){
			if (!x[i]) {
				count++;
				for (int k=i<<1; k<n; k+=i) {
					x[k] = true;
				}
			}
		}
		return count;
	}
	// use bitset on array of int
	public int countPrimes2(int n) {
		int len = 1 + (n>>5);
		int[] x = new int[len];
		int count = 0;
		for(int i=2; i<n; i++) {
			int offset = i>>5;
			int mask = 1<<((i & 0x1f) - 1);
			if ((x[offset] & mask)==0) {
				count++;
				for(int z=i<<1; z<n; z+=i){
					int o = z>>5;
					int m = 1<<((z & 0x1f) - 1);
					x[o] = x[o]|m;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().countPrimes2(10));
	}

}
