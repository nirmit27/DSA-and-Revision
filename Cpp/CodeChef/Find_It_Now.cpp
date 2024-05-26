// Program to find the number occuring after a given number whose digits are pair-wise disjoint!
#include <bits/stdc++.h>
using namespace std;
#define ll long long

bool checker(ll n)
{
    vector<int> arr;
    while (n != 0)
    {
        arr.push_back(n % 10); // pushing the digits into the vector
        n /= 10;               // slicing the number's digits
    }
    sort(arr.begin(), arr.end());
    for (int i = 0; i < (arr.size() - 1); i++)
    {
        if (arr[i] == arr[i + 1]) // if any pair of digits in the number are not pair-wise disjoint, then 0 is returned.
            return 0;
    }
    return 1; // if the entire vector is traversed without any occurence of identical digits, then 1 is returned!
}

void solver()
{
    ll x, y;
    cout << "\n Enter the number after which the pair-wise disjoint digit number is to be found : ";
    cin >> x;
    y = ++x;
    while (checker(y) == 0) // only when 1 is returned by the checker() fn., the reqd. number gets printed!
        y++;
    cout << "\n The required number is : " << y << endl;
}

int main(int argc, char const *argv[])
{
    int t;
    cout << "\n Enter the number of test cases : ";
    cin >> t;
    while (t--)
    {
        solver();
    }

    return 0;
}
