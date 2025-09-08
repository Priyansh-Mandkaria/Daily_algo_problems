// Last updated: 9/9/2025, 1:40:31 AM
class Solution {
    List<List<String>> ans;
    HashMap<String, Integer> map;
    String beginW;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return ans;

        beginW = beginWord;
        map = new HashMap<>();
        map.put(beginWord, 0);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        HashSet<String> vis = new HashSet<>();
        vis.add(beginWord);

        int level = 0;
        boolean found = false;

        // BFS to build shortest distance map
        while (!q.isEmpty()) {
            int n = q.size();
            level++;
            for (int i = 0; i < n; i++) {
                String word = q.poll();
                if (word.equals(endWord)) found = true;
                if (found) continue;

                char[] arr = word.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    char ch = arr[j];
                    for (int k = 'a'; k <= 'z'; k++) {
                        arr[j] = (char) k;
                        String newWord = new String(arr);
                        if (set.contains(newWord) && !vis.contains(newWord)) {
                            q.offer(newWord);
                            vis.add(newWord);
                            map.put(newWord, level);
                        }
                    }
                    arr[j] = ch;
                }
            }
            if (found) break;
        }

        // DFS to reconstruct all shortest paths
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(path, endWord);

        return ans;
    }

    private void dfs(List<String> path, String word) {
        if (word.equals(beginW)) {
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            ans.add(copy);
            return;
        }

        char[] arr = word.toCharArray();
        for (int j = 0; j < word.length(); j++) {
            char ch = arr[j];
            for (int k = 'a'; k <= 'z'; k++) {
                arr[j] = (char) k;
                String newWord = new String(arr);
                if (map.containsKey(newWord) && map.get(newWord) == map.get(word) - 1) {
                    path.add(newWord);
                    dfs(path, newWord);
                    path.remove(path.size() - 1); // backtrack
                }
            }
            arr[j] = ch;
        }
    }
}