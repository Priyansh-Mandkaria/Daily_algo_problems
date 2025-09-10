// Last updated: 9/10/2025, 12:52:38 PM
class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        BitSet[] usersLanguages = new BitSet[m];
        for (int i = 0; i < m; i++) {
            usersLanguages[i] = new BitSet(n);
            for (int lang : languages[i]) {
                usersLanguages[i].set(lang - 1);
            }
        }
        int minPeopleToTeach = Integer.MAX_VALUE;
        for (int targetLangNum = 1; targetLangNum <= n; targetLangNum++) {
            int targetLangIndex = targetLangNum - 1;
            BitSet usersToTeachCurrentLang = new BitSet(m);
            for (int[] friendship : friendships) {
                int uIndex = friendship[0] - 1;
                int vIndex = friendship[1] - 1;
                if (!usersLanguages[uIndex].intersects(usersLanguages[vIndex])) {
                    if (!usersLanguages[uIndex].get(targetLangIndex)) {
                        usersToTeachCurrentLang.set(uIndex);
                    }
                    if (!usersLanguages[vIndex].get(targetLangIndex)) {
                        usersToTeachCurrentLang.set(vIndex);
                    }
                }
            }
            int peopleCountForThisTargetLang = usersToTeachCurrentLang.cardinality();
            minPeopleToTeach = Math.min(minPeopleToTeach, peopleCountForThisTargetLang);
        }
        return minPeopleToTeach;
    }
}