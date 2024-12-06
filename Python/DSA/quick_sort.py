""" Implementation of Quick Sort """


def partition(arr, low, high) -> int:
    i = low - 1
    pivot = arr[high]

    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            (arr[i], arr[j]) = (arr[j], arr[i])

    (arr[i + 1], arr[high]) = (arr[high], arr[i + 1])

    return i + 1


def quick_sort(arr, low, high):
    if low < high:
        pivot = partition(arr, low, high)

        quick_sort(arr, low, pivot - 1)
        quick_sort(arr, pivot + 1, high)


if __name__ == "__main__":
    array = list(map(int, input("\nEnter the array : ").split()))

    quick_sort(array, 0, len(array) - 1)

    print("\nSorted array:", end=" ")
    for x in array:
        print(x, end=" ")
    print()
