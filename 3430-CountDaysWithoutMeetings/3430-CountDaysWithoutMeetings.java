// Last updated: 7/10/2025, 8:51:11 AM
class Solution {
    public int countDays(int days, int[][] meetings) {
        List<int[]> events = new ArrayList<>();
        for (int[] meeting : meetings) {
            events.add(new int[]{meeting[0], 1});
            events.add(new int[]{meeting[1] + 1, -1});
        }
        events.sort(Comparator.comparingInt(a -> a[0]));
        int availableDays = 0, activeMeetings = 0, prevDay = 1;
        for (int[] event : events) {
            int currDay = event[0], change = event[1];
            if (activeMeetings == 0) {
                availableDays += (currDay - prevDay);
            }
            activeMeetings += change;
            prevDay = currDay;
        }
        if (activeMeetings == 0) {
            availableDays += (days - prevDay + 1);
        }
        return availableDays;
    }
}