"""
Recursion

- Lecture #1
"""


def f1_bt(i: int, n: int) -> None:
    if i < 1:
        return

    f1_bt(i - 1, n)
    print(f" Nirmit #{i}")  # NOTE: Backtracking step


def f1_bt_rev(i: int, n: int) -> None:
    if i == n:
        return

    f1_bt_rev(i + 1, n)
    print(f" Nirmit #{i + 1}")  # NOTE: Backtracking step


def f1(i: int, n: int) -> None:
    if i == n:
        return

    print(f" Nirmit #{i + 1}")
    f1(i + 1, n)


def f1_rev(i: int) -> None:
    if i < 1:
        return

    print(f" Nirmit #{i}")
    f1_rev(i - 1)


# NOTE: Driver code
if __name__ == "__main__":
    try:
        n: int = int(input("Enter the limit: ").strip())

        # NOTE: Forwards
        # f1(0, n)
        # f1_rev(n - 1)

        # NOTE: Backtracking
        f1_bt(n, n)
        print("-" * 12)
        f1_bt_rev(0, n)
    except Exception as e:
        print(f"\nERROR: {e}")
