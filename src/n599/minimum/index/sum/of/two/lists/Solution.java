package n599.minimum.index.sum.of.two.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>599. Minimum Index Sum of Two Lists</p>
 * <p>Difficulty:Easy</p>
 * <p>Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants
 * represented by strings.</p>
 * <p>You need to help them find out their common interest with the least list index sum. If there is a choice tie
 * between answers, output all of them with no order requirement. You could assume there always exists an answer.</p>
 * <p>Example 1:
 <pre>Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 Output: ["Shogun"]
 Explanation: The only restaurant they both like is "Shogun".</pre></p>
 <p><pre>Example 2:
 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["KFC", "Shogun", "Burger King"]
 Output: ["Shogun"]
 Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).</pre></p>
 <p>Note:<ol>
 <li>The length of both lists will be in the range of [1, 1000].</li>
 <li>The length of strings in both lists will be in the range of [1, 30].</li>
 <li>The index is starting from 0 to the list length minus 1.</li>
 <li>No duplicates in both lists.</li></ol>
 * </p>
 */
public class Solution {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map1 = new HashMap<>();
		for (int i=list1.length-1; i>=0; i--){
			map1.put(list1[i], i);
		}
		ArrayList<String> result = new ArrayList<>();
		int minSum = Integer.MAX_VALUE;
		for (int i=list2.length-1; i>=0; i--){
			String s = list2[i];
			if (map1.containsKey(s)){
				int sum = i+map1.get(s);
				if (sum<minSum){
					result.clear();
					result.add(s);
					minSum = sum;
				} else if (sum==minSum){
					result.add(s);
				}
			}
		}
		String[] r = new String[result.size()];
		result.toArray(r);
		return r;
	}
}
