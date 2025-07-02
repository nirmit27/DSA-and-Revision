"""
[Leetcode] #696 Count Binary Substrings
Link: https://leetcode.com/problems/count-binary-substrings/
"""

from sys import argv


class CBS:
    @staticmethod
    def count_binary_substrings(s: str) -> int:
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


def main() -> None:
    ipt: str = argv[1]

    try:
        assert all(ch == "0" or ch == "1" for ch in ipt)
    except AssertionError as ae:
        print(f"\nInvalid input string.\n")
        exit(1)

    ans: int = CBS.count_binary_substrings(ipt)
    print(f"\nNumber of valid binary substrings : {ans}\n")


if __name__ == "__main__":
    main()
