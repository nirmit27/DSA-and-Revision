/*
QUICK SORT
*/

#include <stdio.h>
#include <stdlib.h>

int partition(int arr[], int beg, int end)
{
    int left, right, temp, loc, flag = 0;
    left = loc = beg, right = end;

    while (flag != 1)
    {
        while ((arr[loc] <= arr[right]) && (loc != right))
            right--;
        if (loc == right)
            flag++;
        else if (arr[loc] > arr[right])
        {
            temp = arr[loc];
            arr[loc] = arr[right];
            arr[right] = temp;
            loc = right;
        }

        if (flag != 1)
        {
            while ((arr[loc] >= arr[left]) && (loc != left))
                left++;
            if (loc == left)
                flag++;
            else if (arr[loc] < arr[left])
            {
                temp = arr[loc];
                arr[loc] = arr[left];
                arr[left] = temp;
                loc = left;
            }
        }
    }

    return loc;
}

void quick_sort(int arr[], int beg, int end)
{
    int loc;
    if (beg < end)
    {
        loc = partition(arr, beg, end);
        quick_sort(arr, beg, loc - 1);
        quick_sort(arr, loc + 1, end);
    }
}

void print(int *arr, int n)
{
    printf("\n Sorted Array : ");
    for (int i = 0; i < n; i++)
        printf(" %d", *(arr + i));
    printf("\n\n");
}

int main()
{
    int n;
    printf("\n Enter the number of elements in the array : ");
    scanf("%d", &n);

    int *arr = (int *)malloc(n * sizeof(int));
    printf("\n Enter the elements : ");
    for (int i = 0; i < n; i++)
        scanf("%d", arr + i);

    quick_sort(arr, 0, (n - 1));
    print(arr, n);

    return 0;
}
