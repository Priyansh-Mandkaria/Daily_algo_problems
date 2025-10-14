// Last updated: 10/14/2025, 11:49:13 PM
class Solution {
    public String interpret(String command) {
        command = command.replaceAll("\\(\\)","o");
        command = command.replaceAll("\\(al\\)","al");
        return command;
    }
}