// Program to reverse a string word-wise
#include<bits/stdc++.h>
using namespace std;

string reverseStringWordWise(string input)
{
    vector<string> words;
    int n = input.size();
    string word;
    
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

    int i = 0, j = words.size() - 1;
    while (i < j)
    {
        swap(words[i], words[j]);
        i++;
        j--;
    }

    string ans;
    for (int i = 0; i < words.size(); i++)
    {
        ans.append(words[i]);
        ans.push_back(' ');
    }
    return ans;
}


int main()
{
    string str;
    cout<<"Enter a sentence: ";
    getline(cin, str);

    string ans = reverseStringWordWise(str);
    cout << ans << endl;

    return 0;
}