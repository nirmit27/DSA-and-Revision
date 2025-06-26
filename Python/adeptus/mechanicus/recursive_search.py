""" Implementation of Recursive Linear and Binary Search """


def linear_search(arr, size, x):
    if size == 0:
        return -1
    elif arr[size - 1] == x:
        return size - 1
    return linear_search(arr, size - 1, x)


def binary_search(arr, left, right, x):
    if right >= left:
        m = left + (right - left) // 2
        if arr[m] == x:
            return m
        elif arr[m] > x:
            return binary_search(arr, left, m - 1, x)
        else:
            return binary_search(arr, m + 1, right, x)
    else:
        return -1


if __name__ == "__main__":
    key = int(input("\nEnter the key : "))
    array = list(map(int, input("\nEnter the array : ").split()))
    array = sorted(array)
    print(f"\nSorted array : {array}")
    ch = int(
        input(
            "\nChoose the method :\n1 - Binary Search\n2 - Linear Search\n\nEnter your choice : "
        )
    )

    match ch:
        case 1:
            index = binary_search(array, 0, len(array) - 1, key)
            (
                print(f"\n{key} found at index : {index}\n")
                if index != -1
                else print("\nKey not found.\n")
            )
        case 2:
            index = linear_search(array, len(array), key)
            (
                print(f"\n{key} found at index : {index}\n")
                if index != -1
                else print("\nKey not found.\n")
            )
        case _:
            print("\nWrong choice!\n")
