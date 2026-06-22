# Last updated: 6/22/2026, 1:34:56 PM
class Solution:
    def totalBeauty(self, A: List[int]) -> int:
        MOD = 10**9 + 7
        M = max(A) + 1
        locs = defaultdict(list)
        for i, x in enumerate(A):
            locs[x].append(i)

        F = [0] * M
        for d in range(1, M):
            indices = sorted(i for v in range(d, M, d) for i in locs[v])
            if len(indices) <= 1:
                F[d] = len(indices)
                continue

            rank = {pos: r for r, pos in enumerate(indices, 1)}
            fen = Fenwick(len(indices))
            for v in range(d, M, d):
                for pos in reversed(locs[v]):
                    r = rank[pos]
                    addend = 1 + fen.sum(r - 1)
                    F[d] += addend
                    fen.add(r, addend)

        for d in range(M - 1, 0, -1):
            for e in range(2 * d, M, d):
                F[d] -= F[e]
            F[d] %= MOD

        return sum(d * F[d] for d in range(1, M)) % MOD


class Fenwick:
    def __init__(self, n):
        self.a = [0] * (n + 1)

    def sum(self, i):
        s = 0
        while i > 0:
            s += self.a[i]
            i -= i & -i
        return s

    def add(self, i, x):
        while i < len(self.a):
            self.a[i] += x
            i += i & -i