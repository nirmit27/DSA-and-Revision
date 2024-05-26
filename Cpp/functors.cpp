/* Introduction to Functors a.k.a. Function Objects */

#include <vector>
#include <iostream>
#include <algorithm>
#include <functional>

using namespace std;

class Increment // Creating a user-defined functor
{
private:
    int increment;

public:
    Increment(int i) : increment(i) {}
    int operator()(int n)
    {
        return n + increment;
    }
};

int main()
{
    int n, inc;
    vector<int> nums;

    cout << "Enter a number and an increment value : ";
    cin >> n >> inc;

    nums.reserve(n);

    Increment increment = Increment(inc);
    cout << endl
         << n << " incremented by " << inc << " = " << increment(n);

    cout << endl
         << endl
         << "Enter the elements for sample array of length " << n << " : ";
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        nums.push_back(x);
    }

    sort(nums.begin(), nums.end(), greater<int>()); // Using a pre-defined functor greater<int>() for sorting in DESCENDING order

    cout << endl
         << "Sorted array : ";
    for (int num : nums)
        cout << num << " ";

    return 0;
}