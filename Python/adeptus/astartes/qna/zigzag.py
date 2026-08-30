"""
[Leetcode] #6 Word Search

Link: https://leetcode.com/problems/zigzag-conversion/
"""


def zg_convert(s: str, numRows: int) -> str:
    # NOTE: Edge case - No need to convert.
    if numRows == 1 or numRows >= len(s):
        return s

    mat: list[list[str]] = [[] for _ in range(numRows)]
    idx, dir = 0, 1

    for ch in s:
        mat[idx].append(ch)

        # NOTE: Changing directions
        if idx == 0:
            dir = 1
        if idx == (numRows - 1):
            dir = -1

        idx += dir

    res: str = "".join(["".join(row) for row in mat])
    return res


# NOTE: Driver code
if __name__ == "__main__":
    try:
        s: str = input("I/P string: ").strip()
        n: int = int(input("I/P rows: ").strip())
        zgs: str = zg_convert(s, n)

        print(f"Result: {zgs}")
    except Exception as e:
        print(f"\nERROR: {e}")
        exit(-1)
