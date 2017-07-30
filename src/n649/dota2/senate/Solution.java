package n649.dota2.senate;
/**
 * <p>649. Dota2 Senate
 * <p>Difficulty:Medium
 * <p>In the world of Dota2, there are two parties: the Radiant and the Dire.
 * <p>The Dota2 senate consists of senators coming from two parties. Now the senate wants to make a decision about a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
 * <ol>
 * <li>Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
 * <li>Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and make the decision about the change in the game.
 * </ol>
 * <p>Given a string representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party respectively. Then if there are n senators, the size of the given string will be n.
 * <p>The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
 * <p>Suppose every senator is smart enough and will play the best strategy for his own party, you need to predict which party will finally announce the victory and make the change in the Dota2 game. The output should be Radiant or Dire.
 * <p><b>Example 1:</b><br>
 * Input: "RD"<br>
 * Output: "Radiant"<br>
 * Explanation: The first senator comes from Radiant and he can just ban the next senator's right in the round 1.
 * And the second senator can't exercise any rights any more since his right has been banned. 
 * And in the round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
 * <p><b>Example 2:</b><br>
 * Input: "RDD"<br>
 * Output: "Dire"<br>
 * Explanation:The first senator comes from Radiant and he can just ban the next senator's right in the round 1.
 * And the second senator can't exercise any rights anymore since his right has been banned.
 * And the third senator comes from Dire and he can ban the first senator's right in the round 1.
 * And in the round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
 * <p><b>Note:</b>
 * The length of the given string will in the range [1, 10,000].
 * 
 */
public class Solution {	
    public String predictPartyVictory(String senate) {
        char[] s = senate.toCharArray();
        int r = 0, d = 0;
        for (char c: s){
            if (c=='R'){
                r++;
            }
            if (c=='D'){
                d++;
            }            
        }
     
        while (r>0 && d>0){
            for (int i=0; r>0 && d>0 && i<s.length; i++){
                char ban = 'X';
                if (s[i]=='R'){
                    ban = 'D';
                    d--;
                } else if (s[i]=='D'){
                    ban = 'R';
                    r--;
                }
                if (ban!='X'){
                	// always ban senator behind current
                    int k=i+1;
                    for (; k<s.length && s[k]!=ban; k++);
                    if ( k<s.length){
                        s[k] = 'X';
                    } else {
                    	for (k=0; k<i && s[k]!=ban; k++);
                    	if (k<i){
                    		s[k] = 'X';
                    	}                    	
                    }                    
                }                
            }
        }
        return(d==0) ? "Radiant":"Dire";
    }

    public static void main(String[] args) {
		System.out.println(new Solution().predictPartyVictory("DRRDRDRDRDDRDRDR"));
	}

}
