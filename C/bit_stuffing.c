#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void bitStuffer(char *data, char *stuffedData, int skip) {
  int j = 0, count = 0;

  for (int i = 0; i < strlen(data); i++) {
    if (*(data + i) == '1')
      count++;
    else
      count = 0;

    *(stuffedData + j++) = *(data + i);

    if (count == skip) {
      *(stuffedData + j++) = '0';
      count = 0;
    }
  }
}

int main() {
  int size, n;
  char *data;
  char *stuffedData;

  printf("Enter the number of bits in the data : ");
  scanf("%d", &size);

  printf("\nEnter the number of '1' bits to skip : ");
  scanf("%d", &n);

  data = (char *)malloc(n * sizeof(char));
  stuffedData = (char *)malloc((n * 2) * sizeof(char));

  printf("\nEnter the data : ");
  scanf("%s", data);

  bitStuffer(data, stuffedData, n);

  printf("\nAfter bit stuffing operation : %s\n", stuffedData);

  return 0;
}
