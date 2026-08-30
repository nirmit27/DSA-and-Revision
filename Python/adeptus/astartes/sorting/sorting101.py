"""
Sorting 101
"""

from random import randint


def bubble_sort(array: list[int]) -> None:
    if len(array) < 2:
        return

    n: int = len(array)

    for i in range(n - 1):
        check: bool = True

        for j in range(n - i - 1):
            if array[j] > array[j + 1]:
                check = False
                array[j + 1], array[j] = array[j], array[j + 1]

        if check:
            return


def selection_sort(array: list[int]) -> None:
    if len(array) < 2:
        return

    for i in range(len(array)):
        mini = i

        for j in range(i + 1, len(array)):
            if array[mini] > array[j]:
                mini = j

        array[mini], array[i] = array[i], array[mini]


def insertion_sort(array: list[int]) -> None:
    if len(array) < 2:
        return

    for i in range(1, len(array)):
        j = i - 1
        k = array[i]

        while j >= 0 and k < array[j]:
            array[j + 1] = array[j]
            j -= 1

        array[j + 1] = k


def main() -> None:
    """
    try:
        arr: list = input("Array : ").split()
        assert all(x.isdigit() or int(x) for all x in arr), "Error : Invalid input."
    except Exception as e:
        exit(print(f"\nError : {e}\n"))
    """
    # arr = list(map(int, arr))

    limit = int(1e1)
    arr = [randint(-limit, limit + 1) for _ in range(limit)]

    print(f"I/P array: {arr}")

    insertion_sort(arr)
    # bubble_sort(arr)
    # selection_sort(arr)

    print(f"\nO/P array: {arr}\n")


# Driver code
if __name__ == "__main__":
    main()
