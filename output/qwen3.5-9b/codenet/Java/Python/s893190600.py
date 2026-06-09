import sys
from typing import List, Optional

class PP:
    def __init__(self, val1: int, val2: int):
        self.val1 = val1
        self.val2 = val2
    
    def getVal1(self) -> int:
        return self.val1
    
    def setVal1(self, val1: int):
        self.val1 = val1
    
    def getVal2(self) -> int:
        return self.val2
    
    def setVal2(self, val2: int):
        self.val2 = val2


class PPL:
    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
    
    def getKey(self) -> int: