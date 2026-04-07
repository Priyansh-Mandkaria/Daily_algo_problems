// Last updated: 4/7/2026, 10:00:44 PM
1// Added using AI
2class Robot {
3    int x, y, width, height;
4    String dir;
5
6    public Robot(int width, int height) {
7        this.x = 0; this.y = 0;
8        this.dir = "East" ;
9        this.width = width; this.height = height;
10    }
11
12    public void step(int num) {
13        int perim = 2 * (width - 1) + 2 * (height - 1);
14        num %= perim;
15        if (num == 0) num = perim;
16
17        while (num > 0) {
18            int nx = x, ny = y;
19            if (dir.equals("East")) {
20                int maxX = Math.min(x + num, width - 1);
21                int rem  = num - (maxX - x) ;
22                num = rem;
23                if (rem == 0) x = maxX;
24                else          { x = maxX; dir = "North"; }
25            } else if (dir.equals("West")) {
26                int minX = Math.max(x - num, 0);
27                int rem  = num - (x - minX) ;
28                num = rem;
29                if (rem == 0) x = minX;
30                else          { x = minX; dir = "South"; }
31            } else if (dir.equals("North")) {
32                int maxY = Math.min(y + num, height - 1);
33                int rem  = num - (maxY - y) ;
34                num = rem;
35                if (rem == 0) y = maxY;
36                else          { y = maxY; dir = "West"; }
37            } else if (dir.equals("South")) {
38                int minY = Math.max(y - num, 0);
39                int rem  = num - (y - minY) ;
40                num = rem;
41                if (rem == 0) y = minY;
42                else          { y = minY; dir = "East"; }
43            }
44        }
45    }
46
47    public int[] getPos() { return new int[]{x, y}; }
48    public String getDir() { return dir; }
49}