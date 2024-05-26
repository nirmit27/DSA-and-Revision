#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t, n, x;
    long int cost;

    cout << "\n Enter the number of test cases : ";
    cin >> t;

    while (t--)
    {
        cout << "\n Enter the number of days and the taxi fare : ";
        cin >> n >> x;

        cost = 0;
        int *rain_status = new int[n];

        cout << "\n Enter the status of rainfall : 0 - Rain / 1 - No Rain\n\n";
        for (int i = 0; i < n; i++)
            cin >> rain_status[i];

        for (int j = 0; j < n; j++)
        {
            if (rain_status[j] == 1)
                cost += x;
            else if (j > 0)
            {
                if (rain_status[j - 1] == 1)
                    cost += x;
            }
        }

        cout << "\n Total cost of travelling during " << n << " day/s : ";
        cout << cost << endl;

        delete[] rain_status;
    }

    return 0;
}