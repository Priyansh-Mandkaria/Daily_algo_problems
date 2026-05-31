// Last updated: 5/31/2026, 10:52:19 AM
1class Solution {
2    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
3        Arrays.sort(asteroids);
4
5        long currentMass = mass;
6
7        for (int asteroid : asteroids) {
8            if (currentMass < asteroid) {
9                return false;
10            }
11
12            currentMass += asteroid;
13        }
14
15        return true;
16    }
17}