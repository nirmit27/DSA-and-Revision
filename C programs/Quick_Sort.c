/*
QUICK SORT
*/

#include<stdio.h>
#include<stdlib.h>

void quick_sort(int arr[], int beg, int end){
    
}

void print(int *arr, int n)
{
    printf("\n Sorted Array : ");
    for (int i = 0; i < n; i++)
        printf(" %d", *(arr + i));
    printf("\n");
}

int main()
{
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
