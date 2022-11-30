#include <iostream>
#include <math.h>

using namespace std;

void fact()
{ // function to calculate the factorial of a number
    int n;
    long factorial = 1.0;

    cout << "Enter a positive integer: ";
    cin >> n;

    if (n < 0)
        cout << "Error! Factorial of a negative number doesn't exist.";
    else
    {
        for (int i = 1; i <= n; ++i)
        {
            factorial *= i;
        }
        cout << "Factorial of " << n << " = " << factorial;
    }
}

int main()
{
    fact();
    return 0;
}