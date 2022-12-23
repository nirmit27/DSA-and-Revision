// Program to merge two sorted arrays
#include <stdio.h>
#include <stdlib.h>

int main() {
  int n1, n2, ind1 = 0, ind2 = 0, ind = 0;

  printf("\n Enter the sizes of the two arrays : ");
  scanf("%d %d", &n1, &n2);

  int *a = (int *)malloc(n1 * sizeof(int));
  int *b = (int *)malloc(n2 * sizeof(int));
  int *c = (int *)malloc((n1 + n2) * sizeof(int));

  printf("\n Enter the first SORTED array : ");
  for (int i = 0; i < n1; i++)
    scanf("%d", a + i);

  printf("\n Enter the second SORTED array : ");
  for (int j = 0; j < n2; j++)
    scanf("%d", b + j);

  while (ind1 < n1 && ind2 < n2) {
    if (*(a + ind1) < (*(b + ind2)))
      *(c + (ind++)) = *(a + (ind1++));
    else
      *(c + (ind++)) = *(b + (ind2++));
  }

  if (ind1 == n1) {
    while (ind2 < n2)
      *(c + (ind++)) = *(b + (ind2++));
  }

  if (ind2 == n2) {
    while (ind1 < n1)
      *(c + (ind++)) = *(a + (ind1++));
  }

  printf("\n MERGED array : ");
  for (int x = 0; x < ind; x++)
    printf("%d ", *(c + x));

  return 0;
}