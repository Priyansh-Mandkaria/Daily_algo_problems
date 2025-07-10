// Last updated: 7/10/2025, 8:50:01 AM
import java.util.*;

class Solution {
    public int[] longestSpecialPath(int[][] e, int[] n) {
        int sz = n.length;
        int maxVal = Integer.MIN_VALUE;
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < sz; i++) {
            g.add(new ArrayList<>());
            maxVal = Math.max(n[i], maxVal);
        }

        // Build the graph using adjacency list representation
        for (int[] edge : e) {
            g.get(edge[0]).add(new int[]{edge[1], edge[2]});
            g.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        // Last occurrence array for node values
        int[] last = new int[maxVal + 1];
        Arrays.fill(last, -1);

        // Initialize DFS state variables
        st.clear();
        s = 0;
        maxL = 0;
        minN = 1;

        // Perform DFS from the root node
        dfs(0, -1, 0, g, n, last);
        return new int[]{maxL, minN};
    }

    private List<int[]> st = new ArrayList<>();
    private int s, maxL, minN;

    private void dfs(int v, int p, int d, List<List<int[]>> g, int[] n, int[] last) {
        int idx = st.size();
        int oldPos = last[n[v]];
        int oldS = s;

        // Update the start position to avoid repeating values in the path
        if (oldPos != -1 && oldPos >= s) {
            s = oldPos + 1;
        }

        // Add current node to the stack and update the last occurrence of the node value
        st.add(new int[]{v, (int) d});
        last[n[v]] = idx;

        // If a valid path is found, check if it is the longest or if it needs updating
        if (idx >= s) {
            int len = d;
            if (s > 0) {
                len -= st.get(s)[1];
            }

            int nodes = idx - s + 1;
            if (len > maxL) {
                maxL = len;
                minN = nodes;
            } else if (len == maxL) {
                if (nodes < minN) {
                    minN = nodes;
                }
            }
        }

        // Explore all neighbors of the current node
        for (int[] edge : g.get(v)) {
            int neigh = edge[0];
            if (neigh == p) continue;
            dfs(neigh, v, d + edge[1], g, n, last);
        }

        // Backtrack and restore the last position of the node value
        last[n[v]] = oldPos;
        st.remove(st.size() - 1);
        s = oldS;
    }
}