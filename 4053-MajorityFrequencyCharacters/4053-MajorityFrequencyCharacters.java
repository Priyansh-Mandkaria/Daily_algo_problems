// Last updated: 6/22/2026, 1:34:11 PM
class Solution {
    public String majorityFrequencyGroup(String s) {
        var freq = s.chars()
                .filter(c -> c >= 'a' && c <= 'z')
                .boxed()
                .collect(java.util.stream.Collectors.groupingBy(
                        java.util.function.Function.identity(),
                        java.util.stream.Collectors.counting()));

        var grouped = new HashMap<Long, StringBuilder>(); 
        freq.forEach((ch, f) -> grouped
                .computeIfAbsent(f, k -> new StringBuilder())
                .append((char) (int) ch));

        return grouped.entrySet().stream()
                .max(java.util.Comparator
                        .<Map.Entry<Long, StringBuilder>>comparingInt(e -> e.getValue().length())
                        .thenComparingLong(Map.Entry::getKey))
                .map(e -> e.getValue().toString())
                .orElse("");
    }
}