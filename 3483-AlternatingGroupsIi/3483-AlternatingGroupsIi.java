// Last updated: 7/10/2025, 8:50:57 AM
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: colors) list.add(i);
        for(int i=0; i<k-1; i++) list.add(colors[i]);
        int l = list.size();
        int cnt = 0;
        int i=0;
        int j=1;
        while(j<l) {
            if(list.get(j) == list.get(j-1)) {
                i = j;
            }
            if(j-i+1 == k) {
                i++;
                cnt++;
            }
            j++;
        }
        return cnt;
    }
}