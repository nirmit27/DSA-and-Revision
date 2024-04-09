#include <iostream>
#include <vector>

using namespace std;

typedef vector<int> array;
typedef vector<vector<int>> matrix;

// Displaying the input data ...

void displayData(array arr, int sum)
{
    cout << endl
         << endl
         << "Sum value = " << sum << endl;
    cout << endl
         << "Array : ";
    for (int x : arr)
        cout << x << " ";
    cout << endl;
}

// Recursion + Memoization approach ...

bool solveMem(array &arr, int sum, int n, matrix &dp)
{

    // refer to the video link ...
    if (n == 0 && sum == 0)
        return true;

    // refer to the video link ...
    if (n == 0 && sum != 0)
        return false;

    // returning the memoized sub-problem result ...
    if (dp[n][sum] != -1)
        return dp[n][sum];

    // element CAN be included in the subset ...
    // should it be included (Can it's addition yield the sum?) ...
    if (arr[n - 1] <= sum)
        return dp[n][sum] = solveMem(arr, sum - arr[n - 1], n - 1, dp) ||
                            solveMem(arr, sum, n - 1, dp);

    // element CANNOT be included in the subset ...
    else
        return dp[n][sum] = solveMem(arr, sum, n - 1, dp);
}

// Solution code ... with memoization matrix init.

bool isSubsetSum(array arr, int sum)
{

    // Creating a 2D matrix for memo -> dp[number_of_elements][sum + 1]
    matrix dp(arr.size() + 1, array(sum + 1, -1));

    return solveMem(arr, sum, arr.size(), dp);
}

// Driver code ...

int main()
{
    int n, sum, x;

    array arr;

    cout << "Enter the number of elements : ";
    cin >> n;

    cout << endl
         << "Enter the elements of the set : ";
    for (int i = 0; i < n; i++)
    {
        cin >> x;
        arr.push_back(x);
    }

    cout << endl
         << "Enter the sum : ";
    cin >> sum;

    // displayData(arr, sum);

    isSubsetSum(arr, sum)
        ? cout << endl
               << "The array contains a subset whose sum = " << sum << endl
        : cout << endl
               << "The array does NOT contain a subset whose sum = " << sum
               << endl;

    return 0;
}