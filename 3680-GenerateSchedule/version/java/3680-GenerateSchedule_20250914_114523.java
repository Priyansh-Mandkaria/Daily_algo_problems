// Last updated: 9/14/2025, 11:45:23 AM
class Solution {
    static class Pair {
        int first, second;
        Pair(int f, int s) { first = f; second = s; }
    }

    public int[][] generateSchedule(int n) {
        if (n <= 4) return new int[0][0];

        int tot = n * (n - 1);
        int[][] arr = new int[tot][2];
        List<Pair> list = new ArrayList<>();
        List<Pair> ans = new ArrayList<>();
        Random rand = new Random();

        // generate all matches
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j) list.add(new Pair(i, j));

        while (true) {
            // shuffle matches
            List<Pair> shuffled = new ArrayList<>();
            for (Pair p : list) shuffled.add(new Pair(p.first, p.second));
            Collections.shuffle(shuffled, rand);

            ans.clear();
            int val1 = -1, val2 = -1;
            boolean valid = true;

            for (int k = 0; k < list.size(); k++) {
                boolean added = false;

                for (int i = 0; i < shuffled.size(); i++) {
                    int v1 = shuffled.get(i).first;
                    int v2 = shuffled.get(i).second;

                    if (ans.isEmpty() || (v1 != val1 && v1 != val2 && v2 != val1 && v2 != val2)) {
                        ans.add(shuffled.get(i));
                        val1 = v1;
                        val2 = v2;
                        shuffled.remove(i);
                        added = true;
                        break;
                    }
                }

                if (!added) { valid = false; break; } // dead end, reshuffle
            }

            if (valid) break; // schedule complete
        }

        // fill arr
        for (int i = 0; i < ans.size(); i++) {
            arr[i][0] = ans.get(i).first;
            arr[i][1] = ans.get(i).second;
        }

        return arr;
    }
}