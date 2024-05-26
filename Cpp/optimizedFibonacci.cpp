// Memoized and Tabulated Solutions for Recursive Fibonacci

#include <iostream>
#include <vector>

using namespace std;

/*
Time Complexity  =  O(n)
Space Complexity =  O(n)
*/

// --------------------- BOTTOM - UP approach --------------------- //
int fiboBottomUp(int n)
{
    // Base case ...
    if (n <= 1)
        return n;

    // Tabulation ...
    vector<int> dp(n + 1);

    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++)
        dp[i] = dp[i - 1] + dp[i - 2];

    return dp[n];
}

// --------------------- TOP - DOWN approach ---------------------- //
int fiboTopDown(int n, vector<int> &dp)
{
    // Base case ...
    if (n <= 1)
        return n;

    // Returning the memoized sub-problem result ...
    if (dp[n] != -1)
        return dp[n];

    /*
     Memoizing the smaller sub-problem results ...
     e.g. for calculating fibo(6), we won't have to
     calculate fibo(2) or fibo(4) in every branch along
     the resursion tree and we can simply "remember" them!
    */
    dp[n] = fiboTopDown(n - 1, dp) + fiboTopDown(n - 2, dp);

    return dp[n];
}

int main()
{
    int n, ch;
    cout << "Enter the nth position : ";
    cin >> n;

    cout << endl
         << "Choose the approach :  1) Bottom-up  2) Top-down" << endl
         << "Your choice : ";
    cin >> ch;

    // The table has to include all the indices equal to the value passed
    // i.e. for memoizing to obtain fibo(6), out table should contain index "6"
    vector<int> dp(n, -1);

    switch (ch)
    {
    case 1:
        cout << endl
             << "Bottom - Up approach ..." << endl
             << "The " << n
             << "th Fibonacci number is : " << fiboBottomUp(n - 1) << endl;
        break;

    case 2:
        cout << endl
             << "Top - Down approach ... " << endl
             << "The " << n
             << "th Fibonacci number is : " << fiboTopDown(n - 1, dp) << endl;
        break;

    default:
        cout << endl
             << "Wrong choice!" << endl;
    }

    return 0;
}

// Fibonacci sequence ...
// Position :  1 2 3 4 5 6 7  8   9
// Value    :  0 1 1 2 3 5 8  13  21