// Program to find out the symmetric difference between two sets
#include <stdio.h>
// #include<conio.h>
#include <stdlib.h>

void sym_diff(int *d1, int *d2, int m, int n)
{
    int *sym = (int *)malloc((m + n) * sizeof(int));
    int i, j, l = 0;
    for (i = 0; i < m; i++)
    {
        *(sym + l) = *(d1 + i);
        l++;
    }
    for (j = 0; j < n; j++)
    {
        *(sym + l) = *(d2 + j);
        l++;
    }

    printf("\nSymmetric difference of A and B:\n");
    for (i = 0; i < l; i++)
        printf("%d ", *(sym + i));
    printf("\n");
}

int diff(int *a, int *b, int *d1, int n1, int n2)
{
    int i, j, k = 0, m = 0;
    for (i = 0; i < n1; i++)
    {
        for (j = 0; j < n2; j++)
        {
            if (*(b + j) == *(a + i))
                break;
        }
        if (j == n2)
        {
            for (k = 0; k < m; k++)
            {
                if (*(d1 + k) == *(a + i))
                    break;
            }
            if (k == m)
            {
                *(d1 + m) = *(a + i);
                m++;
            }
        }
    }
    return m;
}

void main()
{
    int i, j, k, n1, n2, m = 0, n = 0, l = 0;
    // clrscr();
    printf("\nEnter n(A) and n(B): ");
    scanf("%d %d", &n1, &n2);

    int *a = (int *)malloc(n1 * sizeof(int));
    int *b = (int *)malloc(n2 * sizeof(int));
    int *d1 = (int *)malloc(n1 * sizeof(int));
    int *d2 = (int *)malloc(n2 * sizeof(int));

    printf("\nEnter set A:\n");
    for (i = 0; i < n1; i++)
    {
        scanf("%d", a + i);
    }

    printf("\nEnter set B:\n");
    for (j = 0; j < n2; j++)
    {
        scanf("%d", b + j);
    }

    m = diff(a, b, d1, n1, n2);
    n = diff(b, a, d2, n2, n1);
    sym_diff(d1, d2, m, n);
    // getch();
}
