"""
[Leetcode] #696 Count Binary Substrings
Link: https://leetcode.com/problems/count-binary-substrings/
"""


class CBS:
    def count_binary_substrings(self, s: str) -> int:
        ans: int = 0
        pc: int = 0
        cc: int = 1

        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                cc += 1
            else:
                ans += min(cc, pc)
                pc = cc
                cc = 1

        # For the last valid substring ...
        ans += min(pc, cc)
        return ans


def main() -> None: ...


if __name__ == "__main__":
    main()
