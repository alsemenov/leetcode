package n332.reconstruct.itinerary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
<p>332. Reconstruct Itinerary
<p>Difficulty: Medium
<p>Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

<p>Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
<p>Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
<p>Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String,List<String>> graph = new HashMap<String,List<String>>();
        for (int i=0; i<tickets.length; i++){
            List<String> ts = graph.get(tickets[i][0]);
            if (ts==null){
                ts = new ArrayList<String>();
                graph.put(tickets[i][0], ts);
            }
            ts.add(tickets[i][1]);
        }
        for (List<String> dest: graph.values()){
            if (dest.size()>1){
                Collections.sort(dest);
            }
        }
        
        List<String> result = new ArrayList<String>();
        result.add("JFK");
        dfs(result, graph, tickets.length+1);
        return result;
    }
    
    private boolean dfs(List<String> path, Map<String,List<String>> graph, int length){
        if (path.size()==length){
            return true;
        }
        String p = path.get(path.size()-1);
        List<String> ts = graph.get(p);
        if (ts!=null){
            int len = ts.size();
            for (int i=0; i<len; i++){
                String d = ts.get(i); 
                if (!"".equals(d)){
                    path.add(d);
                    ts.set(i,"");
                    if (dfs(path, graph, length)){
                        return true;
                    }
                    path.remove(path.size()-1);
                    ts.set(i,d);
                }
            }
        }
        return false;
    }
}
