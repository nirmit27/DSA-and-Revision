"""
[HackerRank] Subarray Division 1
Link: https://www.hackerrank.com/challenges/one-month-preparation-kit-the-birthday-bar/problem
"""

import os
from datetime import datetime


def birthday(s: list[int], d: int, m: int) -> int:
    if m == len(s):
        return 1

    res: int = 0

    for i in range(len(s) - 1):
        slice: list[int] = s[i : i + m]

        if len(slice) == m:
            if sum(slice) == d:
                res += 1

    return res


if __name__ == "__main__":
    op_dir: str = r"../codex"
    if not os.path.exists(op_dir):
        os.mkdir(op_dir)

    # Input
    n = int(input().strip())
    s = list(map(int, input().rstrip().split()))
    first_multiple_input = input().rstrip().split()

    d = int(first_multiple_input[0])
    m = int(first_multiple_input[1])

    # Result
    result = birthday(s, d, m)

    with open(rf"{op_dir}/op_sd1.txt", "a") as opf:
        opf.write(
            f"\nSubmission time : {datetime.now().isoformat()}\nResult = {str(result)}\n"
        )
