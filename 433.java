import java.util.*;

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        // Convert bank to a set for quick lookup
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1;
        }
        
        // Characters allowed in the mutation
        char[] genes = {'A', 'C', 'G', 'T'};
        
        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        // Start BFS with the initial sequence
        queue.offer(start);
        visited.add(start);
        
        int mutations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                // Check if we've reached the target sequence
                if (current.equals(end)) {
                    return mutations;
                }
                
                // Generate all possible mutations
                char[] currentArray = current.toCharArray();
                for (int j = 0; j < currentArray.length; j++) {
                    char originalChar = currentArray[j];
                    
                    for (char gene : genes) {
                        if (gene != originalChar) {
                            currentArray[j] = gene;
                            String nextMutation = new String(currentArray);
                            
                            // If the mutation is valid and not visited, add to queue
                            if (bankSet.contains(nextMutation) && !visited.contains(nextMutation)) {
                                queue.offer(nextMutation);
                                visited.add(nextMutation);
                            }
                        }
                    }
                    
                    // Restore original character for the next iteration
                    currentArray[j] = originalChar;
                }
            }
            mutations++;
        }
        
        // If the target was never reached
        return -1;
    }

   
}
