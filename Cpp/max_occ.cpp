// Program to find the character with maximum number of occurences in a string object
#include <bits/stdc++.h>
using namespace std;

int main()
{
    string s;
    cout << "Enter the string: ";
    getline(cin, s);

    int i, max = 0;
    char res;
    int *count = (int *)calloc(26, sizeof(int)); // initialised to 0

    for (i = 0; i < s.length(); i++)
        *(count + (s[i] - 'a')) += 1;

    for (i = 0; i < 26; i++)
    {
        if (*(count + i) > max)
        {
            max = *(count + i);
            res = ('a' + i);
        }
    }
    cout << "Character with most occurences : " << res;

    free(count);

    return 0;
}