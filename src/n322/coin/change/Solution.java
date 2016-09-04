package n322.coin.change;

import java.util.Arrays;
/**
<p>322. Coin Change
<p>Difficulty: Medium
<p>You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

<p>Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

<p>Example 2:
coins = [2], amount = 3
return -1.

<p>Note:
You may assume that you have an infinite number of each kind of coin.
 *
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount==0){
            return 0;
        }
        
        Arrays.sort(coins);
        int[] result = new int[1];
        result[0] = -1;
        
        count(coins, amount, coins.length-1, 0, result);
        return result[0];
    }
    
    private void count(int[] coins, int amount, int start, int count, int[] result){
        int r = result[0];
        int coin = coins[start];
        for (int k=amount/coin; k>=0; k--){
            int newAmount = amount - k*coin;
            int newCount = count + k;
            if (newAmount>0 && start>0 && (newCount<r || r<0)){
                count(coins, newAmount, start-1, newCount, result);
            } else if (newAmount==0) {
                if (newCount<r || r<0){
                    result[0] = newCount;
                }
                return;
            } else if (start==0 || (newCount>=r && r>0)){
                return;
            }
        }
    }
}
