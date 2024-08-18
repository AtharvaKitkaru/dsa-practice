import java.util.*;

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        
        for (List<Integer> connection: connections ){
            adjList.put(connection[0], connection[1]);
        }
    }
}