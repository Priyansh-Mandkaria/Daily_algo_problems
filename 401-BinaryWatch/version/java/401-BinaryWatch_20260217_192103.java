// Last updated: 2/17/2026, 7:21:03 PM
1class Solution {
2    public List<String> readBinaryWatch(int turnedOn) {
3        List<String> result = new ArrayList<>();
4        for (int hour = 0; hour < 12; hour++) {
5            for (int minute = 0; minute < 60; minute++) {
6        int totalBits = Integer.bitCount(hour) + Integer.bitCount(minute);
7                if (totalBits == turnedOn) {                    
8String time = hour + ":" + (minute < 10 ? "0" + minute :minute);           
9                    result.add(time);
10                }
11            }
12        }
13        return result;
14    }
15}