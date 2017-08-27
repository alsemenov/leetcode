package n668.kth.largest.number.in.multiplication.table;

/**
 * <p>668. Kth largest Number in Multiplication Table</p>
 * <p>Difficulty:Hard</p>
 * <p>Nearly every one have used the Multiplication Table. But could you find out the k-th largest number quickly from the multiplication table?</p>

 <p>Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return the k-th largest number in this table.</p>

 <p></p>Example 1:<pre>
 Input: m = 3, n = 3, k = 5
 Output:
 Explanation:
 The Multiplication Table:
 1	2	3
 2	4	6
 3	6	9

 The 5-th largest number is 3 (1, 2, 2, 3, 3).</pre></p>
 <p>Example 2:
 <pre>Input: m = 2, n = 3, k = 6
 Output:
 Explanation:
 The Multiplication Table:
 1	2	3
 2	4	6

 The 6-th largest number is 6 (1, 2, 2, 3, 4, 6).</pre></p>
 <p>Note:<ol>
 <li>The m and n will be in the range [1, 30000].</li>
 <li>The k will be in the range [1, m * n]</li></ol>
 </p>
 */
public class Solution {

    int count(int mid, int m, int n){
        int r = 0;
        for (int i=1; i<=m; i++){
            r+= Math.min(mid/i, n);
        }
        return r;
    }

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m*n+1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (count(mid, m,n)>=k){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthNumber(3000,3000,500));
    }
}
