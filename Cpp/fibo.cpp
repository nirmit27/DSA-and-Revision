// Program to calculate the Fibonacci number at the nth position using matrix exponentiation algorithm
#include <bits/stdc++.h>
using namespace std;

void multiply(long long int f[2][2], long long int m[2][2])
{
    int mod = pow(10, 9) + 7;
    long long int x = f[0][0] * m[0][0] + f[0][1] * m[1][0];
    long long int y = f[0][0] * m[0][1] + f[0][1] * m[1][1];
    long long int z = f[1][0] * m[0][0] + f[1][1] * m[1][0];
    long long int w = f[1][0] * m[0][1] + f[1][1] * m[1][1];

    f[0][0] = x % mod;
    f[0][1] = y % mod;
    f[1][0] = z % mod;
    f[1][1] = w % mod;
}

void power(long long int f[2][2], int n)
{
    if (n == 0 || n == 1)
        return;
    long long int m[2][2] = {{1, 1}, {1, 0}};
    power(f, n / 2);
    multiply(f, f);

    if (n % 2 != 0)
        multiply(f, m);
}

int fibo(int n)
{
    long long int f[2][2] = {{1, 1}, {1, 0}};
    if (n == 0)
        return 0;
    power(f, n - 1);
    return f[0][0];
}

int main()
{
    int num;
    cout << "Enter the position: ";
    cin >> num;
    cout << "\t" << fibo(num);

    return 0;
}