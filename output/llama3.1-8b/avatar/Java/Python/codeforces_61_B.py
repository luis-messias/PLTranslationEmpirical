import re

class Codeforces61B:
    def __init__(self):
        self.word1 = input().lower()
        self.word2 = input().lower()
        self.word3 = input().lower()

        self.permutations = [
            self.word1 + self.word2 + self.word3,
            self.word1 + self.word3 + self.word2,
            self.word2 + self.word1 + self.word3,
            self.word2 + self.word3 + self.word1,
            self.word3 + self.word2 + self.word1,
            self.word3 + self.word1 + self.word2
        ]

    def solve(self):
        for _ in range(int(input())):
            testCase = input().lower()
            if re.sub('[^a-zA-Z]', '', testCase) in self.permutations:
                print("ACC")
            else:
                print("WA")

if __name__ == "__main__":
    cf61b = Codeforces61B()
    cf61b.solve()