package n134.gas.station;

/**
 * <p>134. Gas Station.</p>
 * <p>Difficulty: Medium</p>
 * <p>There are N gas stations along a circular route, where the amount of gas at station i is gas[i].</p>
 * <p>You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
 * from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.</p>
 * <p>Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.</p>
 * <p><b>Note</b>: The solution is guaranteed to be unique.</p>
 */
public class Solution {
	/**
	 * <p><b>Idea</b>: if we start to travel from A and B is first point we can not reach from A,
	 * then we can not reach B from any point between A and B. If such point exists, we can reach it from A
	 * (because B is first unreachable point) and we can reach B from it. So we have a contradiction,
	 * therefore B is not reachable from any point from A to B.</p>
	 * <p><b>Implementation:</b>Loop through all starting points and go from each as far as possible.
	 * If we have made full circle from current start point, then we found an answer. Otherwise, we have reached point B,
	 * which means that any point between current start point and B can not be good start point - we will
	 * not make full circle. So try next start point after B. This means that we visit each point at most two times,
	 * therefore the solution is O(n).
	 * </p>
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		startLoop:
		for (int start = 0; start<gas.length; start++) {
			int delta = 0;
			for (int i=start; i-start<gas.length; i++){
				int k = (i>=gas.length)?i-gas.length:i;
				delta += gas[k] - cost[k];
				if (delta<0){
					start = i;
					continue startLoop;
				}
			}
			return start;
		}
		return -1;
	}
}
