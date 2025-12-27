// Last updated: 12/27/2025, 10:56:37 AM
1class Solution {
2    	public int mostBooked(int n, int[][] meetings) {
3        		// sort by start
4                		Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
5
6                        		// available rooms
7                                		var rooms = new PriorityQueue<Integer>();
8                                        		for (int i = 0; i < n; i++)
9                                                			rooms.add(i);
10
11                                                            		// { meeting end, room taken } -> sort by end time and by room number
12                                                                    		var runningMeetings = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
13
14                                                                            		// room usage count
15                                                                                    		var count = new int[n];
16                                                                                            		for (int[] meeting : meetings) {
17                                                                                                    			// return room to available if meeting has ended
18                                                                                                                			while (!runningMeetings.isEmpty() && runningMeetings.peek()[0] <= meeting[0])
19                                                                                                                            				rooms.add(runningMeetings.poll()[1]);
20
21                                                                                                                                            			var delayedStart = meeting[0];
22                                                                                                                                                        			if (rooms.isEmpty()) { // no available rooms, adjust the next meeting start time with delay
23                                                                                                                                                                    				var await = runningMeetings.poll();
24                                                                                                                                                                                    				delayedStart = await[0];
25                                                                                                                                                                                                    				rooms.add(await[1]);
26                                                                                                                                                                                                                    			}
27
28                                                                                                                                                                                                                                			// schedule the next meeting
29                                                                                                                                                                                                                                            			var room = rooms.poll();
30                                                                                                                                                                                                                                                        			count[room]++;
31                                                                                                                                                                                                                                                                    			runningMeetings.add(new int[] { delayedStart + meeting[1] - meeting[0], room});
32                                                                                                                                                                                                                                                                                		}
33
34                                                                                                                                                                                                                                                                                        		// find the most used room
35                                                                                                                                                                                                                                                                                                		var maxIdx = 0;
36                                                                                                                                                                                                                                                                                                        		for (int r = 0; r < count.length; r++)
37                                                                                                                                                                                                                                                                                                                			if (count[maxIdx] < count[r])
38                                                                                                                                                                                                                                                                                                                            				maxIdx = r;
39
40                                                                                                                                                                                                                                                                                                                    return maxIdx;                                                                        	}            
41}