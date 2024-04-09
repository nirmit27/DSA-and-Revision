/* Problem Link : https://www.scaler.com/academy/mentee-dashboard/class/9822/assignment/problems/11907/hints?navref=cl_pb_nv_tb */

#include <bits/stdc++.h>

using namespace std;

typedef vector<int> arr;
typedef vector<vector<int>> mat;

int solve(mat &t, mat &dp, int i, int j)
{

    if (dp[i][j] != -1)
        return dp[i][j];

    if (i == t.size() - 1)
        return dp[i][j] = t[i][j];

    int left = solve(t, dp, i + 1, j);
    int right = solve(t, dp, i + 1, j + 1);

    return dp[i][j] = t[i][j] + max(left, right);
}

int solution(mat &t, int n)
{
    mat dp(n, arr(n, -1));
    return solve(t, dp, 0, 0);
}

int main()
{
    int n;
    cout << "Enter the height of triangle : ";
    cin >> n;

    mat triangle(n, arr(n, 0));

    cout << endl
         << "Enter the lower triangular matrix : " << endl
         << endl;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> triangle[i][j];

    cout << endl
         << "Longest distance : " << solution(triangle, n) << endl;

    return 0;
}
