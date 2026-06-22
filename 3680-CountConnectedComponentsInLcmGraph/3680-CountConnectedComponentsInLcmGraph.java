// Last updated: 6/22/2026, 1:37:18 PM
class Solution {
    
    static class Unionfind {
        int[] parent;
        int[] rank;
        int totalComponents;
        
        public Unionfind(int n) {
            parent = new int[n];
            rank = new int[n];
            totalComponents = n;
            
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int u) {
            if (parent[u] == u) {
                return u;
            }
            return parent[u] = find(parent[u]);
        }
        
        public void union(int u, int v) {
            int parentU = find(u);
            int parentV = find(v);
            
            if (parentU != parentV) {
                totalComponents--;
                if (rank[parentU] == rank[parentV]) {
                    parent[parentV] = parentU;
                    rank[parentU]++;
                } else if (rank[parentU] > rank[parentV]) {
                    parent[parentV] = parentU;
                } else {
                    parent[parentU] = parentV;
                }
            }
        }
    }
    
    public int countComponents(int[] nums, int threshold) {
        
        // first let us keep count of all the number that can be potential part of a component
        // we know that numbers that are greater than the threshold, will always be standalone components
        // so let us first get those.
        List<Integer> goodNums = new ArrayList<>();
        
        int totalNums = nums.length;
        
        for (int i = 0; i < totalNums; i++) {
            if (nums[i] <= threshold) {
                goodNums.add(nums[i]);
            }
        }
        
        if (goodNums.size() == 0) {
            // there are no elements that are less than or equal to the threshold, this means that 
            // total components will be equal to the total number of elements
            return totalNums;
        }
        
        Unionfind uf = new Unionfind(goodNums.size());
        
        // now let us keep track of the numbers that are part of good nums
        // and assign groups to them, initially they belong to the group which is the index of the goodNums
        int[] presentElements = new int[threshold + 1];
        
        Arrays.fill(presentElements, -1);
        
        for (int i = 0; i < goodNums.size(); i++) {
            presentElements[goodNums.get(i)] = i;
        }
        
        // now let us assign the lastseen elements which will represent the elements that are multiples
        // of the elements present in good nums
        
        for (int d : goodNums) {
            for (int i = d; i <= threshold; i += d) {
                if (presentElements[i] == -1) {
                    presentElements[i] = presentElements[d];
                } else if (presentElements[i] != presentElements[d]) {
                    uf.union(presentElements[i], presentElements[d]);
                }
            }
        }
        
        return uf.totalComponents + totalNums - goodNums.size();
    }
}