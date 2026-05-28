// Last updated: 5/28/2026, 4:06:03 PM
1class Solution {
2
3    static class Node {
4        int[] child;
5        int idx;
6
7        Node() {
8            child = new int[26];
9            Arrays.fill(child, -1);
10            idx = -1;
11        }
12    }
13
14    List<Node> trie = new ArrayList<>();
15
16    // update best index according to:
17    // 1. smaller length
18    // 2. earlier index
19    void updateIndex(int storedIdx,int newIdx,String[] wordsContainer,int node) {
20        if(storedIdx == -1) {
21            trie.get(node).idx = newIdx;
22            return;
23        }
24
25        int oldLen =wordsContainer[storedIdx].length();
26        int newLen =wordsContainer[newIdx].length();
27
28        if(newLen < oldLen) {
29            trie.get(node).idx = newIdx;
30        }
31        else if(newLen == oldLen && newIdx < storedIdx) {
32            trie.get(node).idx = newIdx;
33        }
34    }
35
36    public int[] stringIndices(String[] wordsContainer,String[] wordsQuery) {
37        trie.add(new Node()); // root node
38
39        // build reverse trie
40        for(int i = 0;i < wordsContainer.length;i++) {
41
42            String word =new StringBuilder(wordsContainer[i]).reverse().toString();
43
44            int node = 0;
45
46            // update root answer
47            updateIndex(trie.get(node).idx,i,wordsContainer,node);
48
49            for(char ch : word.toCharArray()) {
50                int c = ch - 'a';
51
52                if(trie.get(node).child[c] == -1) {
53                    trie.get(node).child[c] =trie.size();
54                    trie.add(new Node());
55                }
56
57                node = trie.get(node).child[c];
58
59                updateIndex(trie.get(node).idx,i,wordsContainer,node);
60            }
61        }
62
63        int[] ans =new int[wordsQuery.length];
64
65        // process queries
66        for(int i = 0;i < wordsQuery.length;i++) {
67
68            String query =new StringBuilder(wordsQuery[i]).reverse().toString();
69
70            int node = 0;
71
72            for(char ch : query.toCharArray()) {
73                int c = ch - 'a';
74
75                if(trie.get(node).child[c] == -1) {
76                    break;
77                }
78                node = trie.get(node).child[c];
79            }
80
81            ans[i] = trie.get(node).idx;
82        }
83
84        return ans;
85    }
86}