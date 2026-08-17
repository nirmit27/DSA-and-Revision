"""
Recursion

- Lecture #2
"""


def facto(n: int) -> int:
    if n <= 1:
        return 1

    return n * facto(n - 1)


def func_sum(n: int) -> int:
    if n < 1:
        return 0

    return n + func_sum(n - 1)


def tail_sum(acc: int, n: int) -> int:
    if n == 0:
        return acc

    # NOTE: Tail recursion
    return tail_sum(acc + n, n - 1)


# NOTE: Driver code
if __name__ == "__main__":
    try:
        n: int = int(input("Enter the limit: ").strip())

        result_sum: int = func_sum(n)  # tail_sum(0, n)
        result_facto: int = facto(n)
        print(f"\nSum: {result_sum}, Factorial ({n}!) = {result_facto}")
    except Exception as e:
        print(f"\nERROR: {e}")
