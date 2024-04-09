// Program to check whether a string is Palindrome or not
#include <bits/stdc++.h>
using namespace std;

int main()
{
    string s;
    cout << "Enter the string: ";
    getline(cin, s);
    int low = 0, high = s.size() - 1, flag = 0;
    while (low < high)
    {
        if (s[low] != s[high])
        {
            flag = 1;
            break;
        }
        low++;
        high--;
    }
    if (flag == 0)
        cout << s << " is a Palindrome String.";
    else
        cout << s << " is not a Palindrome String.";

    return 0;
}