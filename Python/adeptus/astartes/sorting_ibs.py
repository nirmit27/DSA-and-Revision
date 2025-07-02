"""
Revision of sorting algorithms
"""


def bubble_sort(array: list[int]) -> None:
    """Sorts the given **array** of integers using the **bubble sort** algorithm, that does pair-wise swaps for sorting the elements of the given **array**."""
    if len(array) < 2:
        return

    check: bool = False

    for i in range(len(array)):
        for j in range(0, len(array) - i - 1):
            if array[j] > array[j + 1]:
                check = True
                array[j + 1], array[j] = array[j], array[j + 1]

        if not check:
            return


def selection_sort(array: list[int]) -> None:
    """Sorts the given **array** of integers using the **selection sort** algorithm, which finds the correct index for each element of the given **array**."""
    if len(array) < 2:
        return

    for i in range(len(array)):
        mini = i

        for j in range(i + 1, len(array)):
            if array[mini] > array[j]:
                mini = j

        array[mini], array[i] = array[i], array[mini]


def insertion_sort(array: list[int]) -> None:
    """Sorts the given **array** of integers using the **insertion sort** algorithm, which partitions the array into sorted and unsorted portions and inserts the elements from the unsorted portion into the sorted portion."""
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
    """Revision of sorting algorithms"""
    try:
        arr: list = list(map(int, input("Array : ").split(" ")))
        assert all(
            isinstance(x, int) for x in arr
        )  # Input validation is important, my dude.
    except Exception as e:
        print(f"\nERROR : {e}\nExiting ...")
        exit(1)

    insertion_sort(arr)
    # bubble_sort(arr)
    # selection_sort(arr)

    print(f"\nResult : {arr}")


if __name__ == "__main__":
    main()
