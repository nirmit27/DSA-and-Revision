// Program to remove consecutive duplicate characters from a string
#include <bits/stdc++.h>
using namespace std;

string removeDuplicates(string str)
{
    string ans = "";
    int n = str.length();
    for (int i = 0; i < n - 1; i++)
    {
        if (str[i] != str[i + 1])
        {
            ans.push_back(str[i]);
        }
    }
    ans.push_back(str[n - 1]);
    return ans;
}

int main(int argc, char const *argv[])
{
    string sample;
    cout << "Enter the string having consecutive duplicates: ";
    getline(cin, sample);
    cout << removeDuplicates(sample) << endl;
    return 0;
}
