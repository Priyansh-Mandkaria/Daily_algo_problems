// Last updated: 7/10/2025, 8:54:20 AM
class Solution {
    public int maximumPopulation(int[][] logs) {
        // Create an array to store the population changes
        int[] population = new int[101]; // From 1950 to 2050 inclusive
        // Loop through the logs and update the population changes
        for (int[] log : logs) {
            int birthYear = log[0];
            int deathYear = log[1];
            population[birthYear - 1950]++;
            population[deathYear - 1950]--;
        }
        // Find the year with the maximum population
        int maxPopulation = 0;
        int year = 1950;
        int currentPopulation = 0;
        for (int i = 0; i < population.length; i++) {
            currentPopulation += population[i];
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                year = 1950 + i;
            }
        }
        return year;
    }
}