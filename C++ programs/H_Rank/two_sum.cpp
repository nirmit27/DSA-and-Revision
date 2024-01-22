// Returning the pair of numbers that sum up to a target value
// Problem link : https://leetcode.com/problems/two-sum/description/

#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> input, int tgt, int n)
{
    unordered_map<int, int> nums;

    for (int i = 0; i < input.size(); i++)
    {
        int comp = tgt - input[i];

        if (nums.count(comp))
            return {nums[comp], i};

        nums[input[i]] = i;
    }

    return {};
}

int main()
{
    int n, target;
    vector<int> result;

    cout << endl
         << "Enter the number of elements : ";
    cin >> n;

    cout << endl
         << "Enter the elements : " << endl
         << endl;

    vector<int> input(n);

    for (int i = 0; i < n; i++)
        cin >> input[i];

    cout << endl
         << "Enter the target value : ";
    cin >> target;

    result = solution(input, target, n);

    cout << endl
         << "Required value pair from array : { " << input[result[0]] << ", " << input[result[1]] << " }" << endl
         << endl;

    return 0;
}