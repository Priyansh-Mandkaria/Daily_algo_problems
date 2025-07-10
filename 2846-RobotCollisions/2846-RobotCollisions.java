// Last updated: 7/10/2025, 8:52:03 AM
class Solution {
static class Robot {
        int index, position, health;
        char direction;

        Robot(int index, int position, int health, char direction) {
            this.index = index;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> robots = new ArrayList<>();

        // Create robots list with the given data
        for (int i = 0; i < n; i++) {
            robots.add(new Robot(i, positions[i], healths[i], directions.charAt(i)));
        }

        // Sort robots by their positions
        robots.sort(Comparator.comparingInt(r -> r.position));

        Stack<Robot> stack = new Stack<>();

        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Robot top = stack.peek();
                    if (top.health > robot.health) {
                        top.health -= 1;
                        robot = null;
                        break;
                    } else if (top.health < robot.health) {
                        robot.health -= 1;
                        stack.pop();
                    } else {
                        stack.pop();
                        robot = null;
                        break;
                    }
                }
                if (robot != null) {
                    stack.push(robot);
                }
            }
        }

        // Collect the results from the stack and sort by the original indices
        List<Robot> survivors = new ArrayList<>(stack);
        survivors.sort(Comparator.comparingInt(r -> r.index));

        List<Integer> result = new ArrayList<>();
        for (Robot survivor : survivors) {
            result.add(survivor.health);
        }

        return result;
    }
}