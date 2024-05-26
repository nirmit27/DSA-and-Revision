#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

void remDup(vector<int> &arr)
{
    if (arr.size() <= 1)
        return;

    int k = 1;
    for (int i = 1; i < arr.size(); i++)
    {
        if (arr[i] != arr[i - 1])
        {
            arr[k] = arr[i];
            k++;
        }
    }

    while (k)
    {
        arr.pop_back();
        k--;
    }
}

int main()
{
    int n;
    vector<int> arr;

    cout << "Enter the size of array : ";
    cin >> n;

    arr.reserve(n);

    cout << endl
         << "Enter the elements : ";
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        arr.emplace_back(x);
    }

    sort(arr.begin(), arr.end());

    cout << endl
         << "Array status : ";
    for (int x : arr)
        cout << x << " ";

    remDup(arr);

    cout << endl
         << endl
         << "After removing duplicates IN PLACE ...\nArray status : ";
    for (int x : arr)
        cout << x << " ";

    return 0;
}
