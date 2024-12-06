""" Implementation of Selection Sort """


def selection_sort(arr):
    for i in range(len(arr)):
        mini = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[mini]:
                mini = j
        (arr[mini], arr[i]) = (arr[i], arr[mini])


if __name__ == "__main__":
    array = list(map(int, input("\nEnter the array : ").split()))

    selection_sort(array)

    print("\nSorted array :", end=" ")
    for x in array:
        print(x, end=" ")
    print()
