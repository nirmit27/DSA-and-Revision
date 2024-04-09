// Program to reverse each word in a string
#include <bits/stdc++.h>
using namespace std;

string reverseWords(string input)
{
    string word;
    vector<string> words;
    string res;
    int n = input.length();

    for (int i = 0; i < n; i++)
    {
        if (input[i] == ' ')
        {
            words.push_back(word);
            word = "";
        }
        else
        {
            word.push_back(input[i]);
        }
    }
    words.push_back(word);

    for (int i = 0; i < words.size(); i++)
    {
        string ans = words[i];
        int j = ans.length() - 1;
        int k = 0;
        while (k < j)
        {
            swap(ans[k], ans[j]);
            k++;
            j--;
        }
        ans.push_back(' ');
        res += ans;
    }
    return res;
}

int main(int argc, char const *argv[])
{
    string input;
    cout << "Enter the string: ";
    getline(cin, input);
    cout << reverseWords(input) << endl;
    return 0;
}
