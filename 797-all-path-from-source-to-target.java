import java.util.*;

class Solution {

    // perform dfs starting from 0
    // add the current node to path
    // if the current node has no neighbours:
    // if it's the target node:
    // add the path to output
    // else:
    // do nothing
    // explore it's neighbouring nodes
    // drop the current node from the path

    public void dfs(int node, int[][] graph, List<List<Integer>> output, List<Integer> path) {
        path.add(node);

        if (node == graph.length - 1) {
            output.add(path);
            return;
        }

        int[] neighbours = graph[node];

        for (int neighbour : neighbours) {
            dfs(neighbour, graph, output, path);
            path.remove(path.size() - 1); // remove the neighbour node once done with exploring it
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();

        dfs(0, graph, output, path);
        return output;
    }

}