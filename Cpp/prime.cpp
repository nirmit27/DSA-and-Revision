// Program to check whether the number is prime or not

#include <iostream>
#include <cmath>
using namespace std;

void prime(int n)
{
    if (n > 1)
    {
        for (int i = 2; i < (sqrt(n) + 1); i++)
        {
            if (n % i == 0)
            {
                cout << n << " is not Prime" << endl;
                return;
            }
        }
        cout << n << " is Prime." << endl;
        return;
    }
    else
        cout << n << " is not Prime." << endl;
    return;
}

int main(int argc, char const *argv[])
{
    int num;
    cout << "Enter the number to be checked: ";
    cin >> num;
    prime(num);
    getchar();
    return 0;
}