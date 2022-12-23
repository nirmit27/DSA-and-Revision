// Program to count pairs with given sum in an array
#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, sum, count = 0;

    cout << "Enter the size of array: ";
    cin >> n;

    cout << "Enter the sum: ";
    cin >> sum;

    int *arr = new int[n];

    cout << "Enter the array: ";
    for (int i = 0; i < n; i++)
        cin >> *(arr + i);

    for (int i = 0; i < n; i++)
        for (int j = i + 1; j < n; j++)
            if ((*(arr + i) + *(arr + j)) == sum)
                count++;

    cout << "Count of pairs: " << count;

    delete[] arr;
    return 0;
}