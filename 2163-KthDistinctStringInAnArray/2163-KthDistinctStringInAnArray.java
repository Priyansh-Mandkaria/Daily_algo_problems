// Last updated: 7/10/2025, 8:53:50 AM
class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String s : arr) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        ArrayList<String> distinctStrings = new ArrayList<>();
        for (String s : arr) {
            if (countMap.get(s) == 1) {
                distinctStrings.add(s);
            }
        }
        if (distinctStrings.size() < k) {
            return "";
        }
        return distinctStrings.get(k - 1);
    }
}