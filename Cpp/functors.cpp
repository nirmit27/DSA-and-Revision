/* Introduction to Functors a.k.a. Function Objects */

#include <vector>
#include <iostream>

using namespace std;

class Increment
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
    int n, i;
    cout << "Enter a number and an increment value : ";
    cin >> n >> i;

    Increment increment = Increment(i);
    cout << endl
         << n << " incremented by " << i << " = " << increment(n);

    return 0;
}