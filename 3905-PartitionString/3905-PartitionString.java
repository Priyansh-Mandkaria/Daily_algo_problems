// Last updated: 7/10/2025, 8:49:09 AM
class Solution {
    public List<String> partitionString(String s) {
        List<String> segments = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            String currentSegment = s.substring(start, i + 1);
            if (!seen.contains(currentSegment)) {
                segments.add(currentSegment);
                seen.add(currentSegment);
                start = i + 1;
            }
        }
        return segments;
    }
}