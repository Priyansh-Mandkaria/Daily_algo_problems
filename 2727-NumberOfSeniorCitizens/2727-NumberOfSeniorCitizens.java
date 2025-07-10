// Last updated: 7/10/2025, 8:52:18 AM
class Solution {
    public int countSeniors(String[] details) {
        ArrayList<String> list = new ArrayList<String>();
        for(String x : details){
            list.add(x);
        }
        int count = 0;
        for (String detail : list) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}