// for problem description, check out HackerRank problem : Subarray Division

#include <bits/stdc++.h>
using namespace std;

int result(vector<int> s, int d, int m)
{
    int res = 0;
    for (int i = 0; i < s.size(); i++)
    {
        int sum = 0;
        if ((i + m) > s.size())
        {
            return res;
        }
        for (int j = 0; j < m; j++)
        {
            sum += s[i + j];
        }
        if (sum == d)
        {
            res++;
        }
    }
    return res;
}

int main()
{
    int n, d, m, count;

    cout << "\n Enter the length of the bar : ";
    cin >> n;

    vector<int> sample(n);

    cout << "\n Enter the bar's block numbers : ";
    for (auto i = 0; i < n; i++)
        cin >> sample[i];

    cout << "\n Enter the day and month of the birthday : ";
    cin >> d >> m;

    cout << "\n No. of possible segments : " << result(sample, d, m) << endl;

    return 0;
}