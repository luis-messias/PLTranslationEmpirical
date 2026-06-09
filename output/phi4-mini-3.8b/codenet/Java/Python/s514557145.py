import sys

MOD1, MOD2 = 1000000007, 998244353
inv9 = mod_inv(9)

class LazySegTree:
    def __init__(self, dat):
        self.dat = dat
        n = len(dat)
        m = max(len(d) for d in dat if isinstance(d, list))
        self.N = (n + m - 1).bit_length()
        self.LazySegTree.__init__(dat)

    @staticmethod
    def __init__(self, dat):
        S = lambda x: [x]
        F = lambda a, b: [[a], [b]]
        LazySegTree(dat)
    
    class E:
        pass

    op = staticmethod(lambda s1, s2: (s1 + s2) % MOD2)

    map = staticmethod(lambda f, s: inv9 * len(s))

    def __init__(self):
        self.lazy_seg_tree = LazySegTree(dat)
    
    class F:
        pass

    id = lambda x: [x]

    composite = staticmethod(lambda a, b: [[a], [b]])

def mod_inv(x): return pow(x, MOD2 - 2)

tenmod = [1] * (10 ** 6 + 5) if tenmod is None else list(range(0, len(tenmod)))