/*
MERGE SORT
*/

#include <stdio.h>
#include <stdlib.h>

int n;

void merge(int *arr, int beg, int mid, int end)
{
  int *temp = (int *)malloc(n * sizeof(int));
  int i = beg, j = mid + 1, idx = beg;

  while (i <= mid && j <= end)
  {
    if (*(arr + i) < *(arr + j))
      *(temp + (idx++)) = *(arr + (i++));
    else
      *(temp + (idx++)) = *(arr + (j++));
  }

  if (i > mid)
  {
    while (j <= end)
      *(temp + (idx++)) = *(arr + (j++));
  }

  else
  {
    while (i <= mid)
      *(temp + (idx++)) = *(arr + (i++));
  }

  for (int x = beg; x < idx; x++)
    *(arr + x) = *(temp + x);
}

void merge_sort(int *arr, int beg, int end)
{
  int mid;
  if (beg < end)
  {
    mid = (beg + end) / 2;
    merge_sort(arr, beg, mid);
    merge_sort(arr, mid + 1, end);
    merge(arr, beg, mid, end);
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
  printf("\n Enter the number of elements in the array : ");
  scanf("%d", &n);

  int *arr = (int *)malloc(n * sizeof(int));
  printf("\n Enter the elements : ");
  for (int i = 0; i < n; i++)
    scanf("%d", arr + i);

  merge_sort(arr, 0, (n - 1));
  print(arr, n);

  return 0;
}
