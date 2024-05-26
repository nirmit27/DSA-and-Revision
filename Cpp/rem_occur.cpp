// Program to remove all occurences of a given character from a string
#include <bits/stdc++.h>
using namespace std;

string removeAllOccurrencesOfChar(string input, char ch)
{
    string ans;
    for (int i = 0; i < input.length(); i++)
    {
        if (input[i] != ch)
        {
            ans.push_back(input[i]);
        }
    }
    return ans;
}

int main(int argc, char const *argv[])
{
    string input;
    char c;

    cout << "Enter the string and the character to be removed: ";
    cin >> input >> c;
    cout << removeAllOccurrencesOfChar(input, c) << endl;

    return 0;
}