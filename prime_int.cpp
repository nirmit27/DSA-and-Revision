// Program to calculate the number of prime numbers in a given interval
#include <bits/stdc++.h>
#include <iostream>

using namespace std;

// Write your totalPrime function here
int totalPrime(int s, int e)
{
    int i, j, count = 0;
    for (i = s; i <= e; i++)
    {
        for (j = 2; j < i; j++)
        {
            if (i % j == 0)
                break;
        }
        if (j == i)
            count++;
    }
    return count;
}

int main()
{
    int S, E;
    cout << "Enter the range: ";
    cin >> S >> E;
    cout << totalPrime(S, E);
    return 0;
}