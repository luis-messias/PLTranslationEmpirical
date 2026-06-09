import sys
from typing import List

class InputMismatchException(Exception):
    pass

def readByte():
    global ptrbuf, lenbuf, is
    if lenbuf == -1:
        raise InputMismatchException()
    if ptrbuf >= lenbuf:
        try:
            lenbuf = is.read(inbuf)
        except Exception as e:
            print(e)
            raise InputMismatchException()
        if lenbuf <= 0:
            return -1
    return inbuf[ptrbuf]

def skip():
    global ptrbuf, lenbuf, is
    while True:
        b = readByte()
        if b == -1 or not (b >= 33 and b <= 126):
            break
    return b

def ns():
    global ptrbuf, lenbuf, is
    b = skip()
    sb = []
    while True:
        if b != -1 and not (b >= 33 and b <= 126):
            break
        sb.append(chr(b))
        b = readByte()
    return ''.join(sb)

def nm(n: int, m: int) -> List[List[str]]:
    map = [ns(m) for _ in range(n)]
    return map

def na(n: int) -> List[int]:
    a = []
    for i in range(n):
        a.append(int(ns()))
    return a

def nla(n: int) -> List[int]:
    a = []
    for i in range(n):
        a.append(int(ns()))
    return a

def ni() -> int:
    num = 0
    b = readByte()
    minus = False
    while True:
        if b >= '0' and b <= '9':
            num = num * 10 + (b - '0')
        else:
            return minus and -num or num
        b = readByte()

def nl() -> int:
    num = 0
    b = readByte()
    minus = False
    while True:
        if b >= '0' and b <= '9':
            num = num * 10 + (b - '0')
        else:
            return minus and -num or num
        b = readByte()

def isSpaceChar(c: int) -> bool:
    return not (c >= 33 and c <= 126)

def pow(x, y):
    if y < 0:
        return 0
    if y == 0:
        return 1
    if y % 2 == 1:
        return (x * pow(x, y - 1)) % mod
    root = pow(x, y // 2)
    return root * root % mod

def div(x, y):
    return x * pow(y, mod - 2) % mod

def mul(x, y):
    return (x * y) % mod

def plus(x, y):
    return (x + y) % mod

def sub(x, y):
    return (x - y) % mod

mod = 1000000007
is = sys.stdin.buffer
inbuf = bytearray(1024)
ptrbuf = 0
lenbuf = 0

def solve():
    global ptrbuf, lenbuf, is
    while True:
        b = readByte()
        if b == -1:
            break
        inbuf[ptrbuf] = b
        ptrbuf += 1
        if ptrbuf >= lenbuf:
            try:
                lenbuf = is.read(inbuf)
            except Exception as e:
                print(e)
                raise InputMismatchException()
            if lenbuf <= 0:
                break
    n = ni()
    m = ni()
    a = na(n)
    b = na(m)
    c = nm(n, m)
    d = na(n)
    e = na(n)
    f = na(n)
    g = na(n)
    h = na(n)
    i = na(n)
    j = na(n)
    k = na(n)
    l = na(n)
    m = na(n)
    n = na(n)
    o = na(n)
    p = na(n)
    q = na(n)
    r = na(n)
    s = na(n)
    t = na(n)
    u = na(n)
    v = na(n)
    w = na(n)
    x = na(n)
    y = na(n)
    z = na(n)
    aa = na(n)
    ab = na(n)
    ac = na(n)
    ad = na(n)
    ae = na(n)
    af = na(n)
    ag = na(n)
    ah = na(n)
    ai = na(n)
    aj = na(n)
    ak = na(n)
    al = na(n)
    am = na(n)
    an = na(n)
    ao = na(n)
    ap = na(n)
    aq = na(n)
    ar = na(n)
    as_ = na(n)
    at_ = na(n)
    au_ = na(n)
    av_ = na(n)
    aw_ = na(n)
    ax_ = na(n)
    ay_ = na(n)
    az_ = na(n)
    ba = na(n)
    bb = na(n)
    bc = na(n)
    bd = na(n)
    be = na(n)
    bf = na(n)
    bg = na(n)
    bh = na(n)
    bi = na(n)
    bj = na(n)
    bk = na(n)
    bl = na(n)
    bm = na(n)
    bn = na(n)
    bo = na(n)
    bp = na(n)
    bq = na(n)
    br = na(n)
    bs_ = na(n)
    bt_ = na(n)
    bu_ = na(n)
    bv_ = na(n)
    bw_ = na(n)
    bx_ = na(n)
    by_ = na(n)
    bz_ = na(n)
    ca = na(n)
    cb = na(n)
    cc = na(n)
    cd = na(n)
    ce = na(n)
    cf = na(n)
    cg = na(n)
    ch = na(n)
    ci = na(n)
    cj = na(n)
    ck = na(n)
    cl = na(n)
    cm = na(n)
    cn = na(n)
    co = na(n)
    cp = na(n)
    cq = na(n)
    cr = na(n)
    cs_ = na(n)
    ct_ = na(n)
    cu_ = na(n)
    cv_ = na(n)
    cw_ = na(n)
    cx_ = na(n)
    cy_ = na(n)
    cz_ = na(n)
    da = na(n)
    db = na(n)
    dc = na(n)
    dd = na(n)
    de = na(n)
    df = na(n)
    dg = na(n)
    dh = na(n)
    di = na(n)
    dj = na(n)
    dk = na(n)
    dl = na(n)
    dm = na(n)
    dn = na(n)
    do_ = na(n)
    dp_ = na(n)
    dq_ = na(n)
    dr_ = na(n)
    ds_ = na(n)
    dt_ = na(n)
    du_ = na(n)
    dv_ = na(n)
    dw_ = na(n)
    dx_ = na(n)
    dy_ = na(n)
    dz_ = na(n)
    ea = na(n)
    eb = na(n)
    ec = na(n)
    ed = na(n)
    ee = na(n)
    ef = na(n)
    eg = na(n)
    eh = na(n)
    ei = na(n)
    ej = na(n)
    ek = na(n)
    el = na(n)
    em = na(n)
    en = na(n)
    eo_ = na(n)
    ep_ = na(n)
    eq_ = na(n)
    er_ = na(n)
    es_ = na(n)
    et_ = na(n)
    eu_ = na(n)
    ev_ = na(n)
    ew_ = na(n)
    ex_ = na(n)
    ey_ = na(n)
    ez_ = na(n)
    fa = na(n)
    fb = na(n)
    fc = na(n)
    fd = na(n)
    fe = na(n)
    ff = na(n)
    fg = na(n)
    fh = na(n)
    fi = na(n)
    fj = na(n)
    fk = na(n)
    fl = na(n)
    fm = na(n)
    fn = na(n)
    fo_ = na(n)
    fp_ = na(n)
    fq_ = na(n)
    fr_ = na(n)
    fs_ = na(n)
    ft_ = na(n)
    fu_ = na(n)
    fv_ = na(n)
    fw_ = na(n)
    fx_ = na(n)
    fy_ = na(n)
    fz_ = na(n)
    ga = na(n)
    gb = na(n)
    gc = na(n)
    gd = na(n)
    ge = na(n)
    gf = na(n)
    gg = na(n)
    gh = na(n)
    gi = na(n)
    gj = na(n)
    gk = na(n)
    gl = na(n)
    gm = na(n)
    gn = na(n)
    go_ = na(n)
    gp_ = na(n)
    gq_ = na(n)
    gr_ = na(n)
    gs_ = na(n)
    gt_
