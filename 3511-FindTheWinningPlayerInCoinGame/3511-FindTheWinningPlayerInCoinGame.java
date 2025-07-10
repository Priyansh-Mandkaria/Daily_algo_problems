// Last updated: 7/10/2025, 8:50:53 AM
class Solution {
    public String losingPlayer(int x, int y) {
        int remaining_after_the_turn = 0;
        int z = y / 4;
        remaining_after_the_turn = Math.min(x,z);
        if(remaining_after_the_turn % 2 == 0){
            return "Bob";
        }
        if(remaining_after_the_turn % 2 == 1){
            return "Alice";
        }
        return "Alice"; // beacuse she comes first or if any error occured so i have kept this 
    }
}