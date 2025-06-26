"""Some FAQs related to arrays."""


def rem_dups(arr: list[int]) -> int:
    """Return the count of non-duplicate elements from a sorted array."""
    if len(arr) <= 1:
        return 1

    res = 1
    for i in range(1, len(arr)):
        if arr[i] != arr[i - 1]:
            arr[res] = arr[i]
            res += 1

    return res


def rotate(arr: list[int], k: int) -> None:
    """Rotate an array `k` times."""
    k %= len(arr)
    if k == 0:
        return

    arr[:k], arr[k:] = arr[-k:], arr[:-k]


def main() -> None:
    try:
        arr: list[str] = input("Enter the array : ").split(" ") or []
        k: int = int(input("Enter the rotation count : ")) or 0

        # Input validation
        if not all(x.isdigit() or (x.startswith("-") and x[1:].isdigit()) for x in arr):
            raise ValueError(
                "ERROR : Invalid input. The array should ONLY contain integers."
            )

    except ValueError as ve:
        print(ve)
        exit(-1)

    except TypeError as te:
        print("ERROR : Invalid input. The value of 'k' should be a positive integer.")
        exit(-1)

    data: list[int] = list(map(int, arr))

    data = list(set(data))
    print(f"\nAfter removing duplicates : {data}")

    rotate(data, k)
    print(f"\nAfter {k} rotation(s) : {data}")


if __name__ == "__main__":
    main()
