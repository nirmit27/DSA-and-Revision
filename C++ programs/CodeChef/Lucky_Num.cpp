#include <bits/stdc++.h>
using namespace std;

void luc_num(int a)
{
    int c = 0;
    if (a % 2 != 0)
        cout << '\t' << 1 << endl;
        else
        {
            while (a % 2 == 0)
            { // 48 // 24 // 12 // 6 // 3, stop! // c : 1,2,3,4
                a /= 2;
                c++;
            }
            cout << '\t' << (c % 2 == 0) << endl;
        }
}

int main()
{
    int n, x;
    cout << "\n Enter the number of test cases : ";
    cin >> n;
    cout << "\n Enter the values : ";
    while (n--)
    {
        cin >> x;
        luc_num(x);
    }
    return 0;
}