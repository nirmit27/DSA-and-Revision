"""Implementation of Heap Sort"""


def max_heapify(arr, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < n and arr[left] > arr[i]:
        largest = left

    if right < n and arr[right] > arr[largest]:
        largest = right

    if largest != i:
        (arr[largest], arr[i]) = (arr[i], arr[largest])
        max_heapify(arr, n, largest)


def build_max_heap(arr):
    n = len(arr)
    for i in range(n // 2, -1, -1):
        max_heapify(arr, n, i)


def heap_sort(arr):
    build_max_heap(arr)
    for i in range(len(arr) - 1, 0, -1):
        (arr[i], arr[0]) = (arr[0], arr[i])
        max_heapify(arr, i, 0)


if __name__ == "__main__":
    array = list(map(int, input("\nEnter the array : ").split()))
    heap_sort(array)
    print("\nSorted array :", end=" ")
    for x in array:
        print(x, end=" ")
    print()
