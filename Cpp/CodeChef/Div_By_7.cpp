#include <bits/stdc++.h>
using namespace std;
#define ll long long

int main()
{
    int t;
    cout << "\n Enter the number of test cases : ";
    cin >> t;
    while (t--)
    {
        ll x, y, d;
        cout << "\n Enter the number and the exponent for the digits : ";
        cin >> x >> y;
        ll temp = 0; // for holding the sum of the reversed digits, each raised to the power 'y'
        while (x != 0)
        {
            d = x % 10;
            ll z = y % 4; // x^(n%4) has the same digit occuring at the unit's place as x^n ... you can CHECK IT!
            if (z == 0 && y != 0)
                z = 4; // boundary condition... since n^4 != n^0
            d = pow(d, z);
            temp = temp * 10 + d % 10; // we are ONLY concerned with the digit occuring at the unit's place!
            x /= 10;
        }
        (temp % 7 == 0) ? cout << "YES" << endl : cout << "NO" << endl;
    }

    return 0;
}