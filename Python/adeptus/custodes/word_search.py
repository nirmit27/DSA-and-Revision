"""
Word Search

Link: https://leetcode.com/problems/word-search/
"""

from re import match
from traceback import print_exc as trace_print_exc

cleaner_pattern = r"\w"


def solution(word, mat, dims, wrd_size, tgt_size):
    # NOTE: Edge Case #1 - Word length exceeds the matrix size
    if wrd_size > tgt_size:
        return False

    viz = set()
    rows, cols = dims
    dirs = [(0, 1), (1, 0), (-1, 0), (0, -1)]

    def dfs(i, r, c):
        # NOTE: Edge Case #2 - Exceeding word length while scanning
        if i > wrd_size:
            return False

        # NOTE: Recursive cases ...
        if (
            min(r, c) < 0               # NOTE: #1 - Gone too far bacwards
            or r >= rows                # NOTE: #2 - Gone too far down
            or c >= cols                # NOTE: #3 - Gont too far right
            or word[i] != mat[[r][c]]   # NOTE: #4 - Character mismatch
            or (r, c) in viz            # NOTE: #5 - DFS - already visited
        ):
            return False

        viz.add((r, c))
        for dx, dy in dirs:
            if dfs(i + 1, r + dx, r + dy):
                return True

        # NOTE: Backtracking - This path won't do us any good if we continue.
        viz.remove((r, c))
        return res

    for r in range(rows):
        for c in range(cols):
            if dfs(r, c, 0):
                return True

    return False


# NOTE: Driver code
if __name__ == "__main__":
    try:
        s = input("Enter the quote: ").strip()
        w = input("Enter the word: ").strip()
        r, c = list(map(int, input("Enter the dims.: ").split(" ")))

        word = w.upper()
        wrd_size = len(word)
        tgt_size = r * c

        s_clean = "".join(ch for ch in s if match(cleaner_pattern, ch)).upper()
        s_clean = s_clean[:tgt_size].ljust(tgt_size, "_")

        s_iter = iter(s_clean)
        mat = [[next(s_iter) for _ in range(c)] for _ in range(r)]

        res = solution(word, mat, (r, c), wrd_size, tgt_size)
        print(f"Result - {'MATCH FOUND' if res else 'NO MATCH FOUND'}")

    except Exception as e:
        print(f"--- ERROR ---")
        trace_print_exc()
        exit(-1)
