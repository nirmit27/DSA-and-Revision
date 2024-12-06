""" Implementation of Insertion Sort """


def insertion_sort(arr):
    if len(arr) < 2:
        return arr

    for i in range(1, len(arr)):
        j = i - 1
        key = arr[i]
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1

        arr[j + 1] = key


if __name__ == "__main__":
    array = list(map(int, input("\nEnter the array : ").split()))

    insertion_sort(array)

    print("\nSorted array :", end=" ")
    for x in array:
        print(x, end=" ")
    print()
