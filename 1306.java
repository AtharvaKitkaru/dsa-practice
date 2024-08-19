import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        Integer nextJump, prevJump;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer pos = queue.poll();

                if (arr[pos] == 0) {
                    return true;
                } else {
                    nextJump = pos + arr[pos];
                    prevJump = pos - arr[pos];

                    if (nextJump >= 0 && nextJump < arr.length && !visited.contains(nextJump)) {
                        queue.add(nextJump);
                        visited.add(nextJump);
                    }
                    if (prevJump >= 0 && prevJump < arr.length && !visited.contains(prevJump)) {
                        queue.add(prevJump);
                        visited.add(prevJump);
                    }
                }
            }
        }

        return false;
    }
}