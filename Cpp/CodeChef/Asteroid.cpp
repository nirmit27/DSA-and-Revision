#include <bits/stdc++.h>
#define ll long long
using namespace std;

int main()
{
    int t, i;
    cin >> t;
    vector<pair<ll, ll>> ast;
    ll n, dir, size;
    while (t--)
    {
        ast.clear();
        cin >> n;
        for (i = 0; i < n; i++)
        {
            cin >> dir >> size;
            ast.push_back(make_pair(dir, size));
        }
        stack<ll> temp;
        vector<ll> ans;
        for (i = 0; i < n; i++)
        {
            if (ast[i].first == 1) // pick one asteroid that's moving towards right
                temp.push(i);      // push it onto the stack // also, in case all of them are moving towards right
            else
            {
                while (!temp.empty() && (ast[temp.top()].second < ast[i].second)) // compare with other asteroids
                {
                    ast[i].second += ast[temp.top()].second; // if the one on stack is smaller, it's mass gets taken away
                    temp.pop();                              // ...and it gets destroyed!
                }
                if (!temp.empty()) // if that wasn't the case ...
                {
                    if (ast[temp.top()].second > ast[i].second) // the one on the stack gains more mass and destroys other
                        ast[temp.top()].second += ast[i].second;
                    else
                        temp.pop(); // else if both the adjacent 'roids are same in mass, they'll annihilate each other!
                }
                else
                    ans.push_back(i); // if all the 'roids are moving towards left, then push all of 'em to stack
            }
        }
        while (!temp.empty())
        {
            ans.push_back(temp.top()); // start popping all the index numbers of the asteroids that remain!
            temp.pop();
        }
        sort(ans.begin(), ans.end());
        cout << ans.size() << endl; // print the number of remaining asteroids
        if (ans.size() > 0)
        {
            for (auto x : ans)
                cout << x + 1 << " "; // print the indices of remaining asteroids
        }
    }
    
    return 0;
}