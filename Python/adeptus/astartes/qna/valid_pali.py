"""
[Leetcode] #125 Valid Palindrone

Link: https://leetcode.com/problems/valid-palindrome/
"""


def pali(s: str) -> bool:
    s_: str = "".join(ch.lower() for ch in s if ch.isalnum())
    n_: int = len(s_)

    def solve(i: int) -> bool:
        if i >= (n_ // 2):
            return True

        if s_[i] != s_[n_ - i - 1]:
            return False

        return solve(i + 1)

    return solve(0)


# NOTE: Driver code
if __name__ == "__main__":
    try:
        s: str = input("I/P string: ")
        print(f"'{s}' is{'' if pali(s) else ' NOT'} a valid palindrome.")
    except Exception as e:
        print(f"\nERROR: {e}")
        exit(-1)
