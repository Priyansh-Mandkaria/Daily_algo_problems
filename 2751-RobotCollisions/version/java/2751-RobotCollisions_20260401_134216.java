// Last updated: 4/1/2026, 1:42:16 PM
1class Solution {
2static class Robot {
3        int index, position, health;
4        char direction;
5
6        Robot(int index, int position, int health, char direction) {
7            this.index = index;
8            this.position = position;
9            this.health = health;
10            this.direction = direction;
11        }
12    }
13
14    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
15        int n = positions.length;
16        List<Robot> robots = new ArrayList<>();
17        for (int i = 0; i < n; i++) {
18            robots.add(new Robot(i, positions[i], healths[i], directions.charAt(i)));
19        }
20        robots.sort(Comparator.comparingInt(r -> r.position));
21        Stack<Robot> stack = new Stack<>();
22        for (Robot robot : robots) {
23            if (robot.direction == 'R') {
24                stack.push(robot);
25            } else {
26                while (!stack.isEmpty() && stack.peek().direction == 'R') {
27                    Robot top = stack.peek();
28                    if (top.health > robot.health) {
29                        top.health -= 1;
30                        robot = null;
31                        break;
32                    } else if (top.health < robot.health) {
33                        robot.health -= 1;
34                        stack.pop();
35                    } else {
36                        stack.pop();
37                        robot = null;
38                        break;
39                    }
40                }
41                if (robot != null) {
42                    stack.push(robot);
43                }
44            }
45        }
46        List<Robot> survivors = new ArrayList<>(stack);
47        survivors.sort(Comparator.comparingInt(r -> r.index));
48        List<Integer> result = new ArrayList<>();
49        for (Robot survivor : survivors) {
50            result.add(survivor.health);
51        }
52        return result;
53    }
54}