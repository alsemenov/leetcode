package n661.image.smoother;
/**
 * <p>661. Image Smoother</p>
 * <p>Difficulty: Easy</p>
 * <p>Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother 
 * to make the gray scale of each cell becomes the average gray scale (rounding down) 
 * of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.</p>

<p>Example 1:
<pre>
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0</pre></p>
<p>Note:<ol>
<li>The value in the given matrix is in the range of [0, 255].</li>
<li>The length and width of the given matrix are in the range of [1, 150].</li></ol></p>
 *
 */
public class Solution {
    public int[][] imageSmoother(int[][] M) {
        final int len1 = M.length, len2 = M[0].length;
        int[][] r = new int[len1][len2];
        for (int i=0; i<len1; i++){
            for (int k=0; k<len2; k++){
                double sum = M[i][k];
                int count = 1;
                if (i-1>=0){
                    sum+=M[i-1][k];
                    count++;
                    if (k-1>=0){
                        sum+=M[i-1][k-1];
                        count++;
                    }
                }
                if (k-1>=0){
                    sum+=M[i][k-1];
                    count++;
                    if (i+1<len1){
                        sum+=M[i+1][k-1];
                        count++;
                    }
                }
                if (i+1<len1){
                    sum+=M[i+1][k];
                    count++;
                    if (k+1<len2){
                        sum+=M[i+1][k+1];
                        count++;
                    }
                }
                if (k+1<len2){
                    sum+=M[i][k+1];
                    count++;
                    if (i-1>=0){
                        sum+=M[i-1][k+1];
                        count++;
                    }
                }
                r[i][k] = (int)Math.floor(sum/count);
            }
        }
        return r;
    }
}
