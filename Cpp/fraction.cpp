// Program to add, subtract and multiply fractions using OOP appraoch!
#include <bits/stdc++.h>

using namespace std;

class Fractions
{
    int numerator;
    int denominator;

public:
    Fractions(int n, int d)
    { // constructor
        this->numerator = n;
        this->denominator = d;
    }

    void print()
    {
        cout << "\nResult = ";
        cout << this->numerator << "/" << this->denominator << endl
             << endl;
    }

    void simplify()
    { // simplification using built-in fn. __gcd()
        int gcd = __gcd(this->numerator, this->denominator);
        this->numerator /= gcd;
        this->denominator /= gcd;
    }

    Fractions operator+(Fractions const &f2) // adding two fractions
    {
        int lcm = this->denominator * (f2.denominator);
        int x = lcm / this->denominator;
        int y = lcm / (f2.denominator);
        int num = numerator * x + (f2.numerator * y);
        Fractions sum(num, lcm);
        sum.simplify();
        return sum;
    }

    Fractions operator-(Fractions const &f2) // subtracting one fraction from another
    {
        int lcm = this->denominator * (f2.denominator);
        int x = lcm / this->denominator;
        int y = lcm / (f2.denominator);
        int num = numerator * x - (f2.numerator * y);
        Fractions diff(num, lcm);
        diff.simplify();
        return diff;
    }

    Fractions operator*(Fractions const &f2) // multiplying two fractions
    {
        int nr = numerator * (f2.numerator);
        int dr = denominator * (f2.denominator);
        Fractions product(nr, dr);
        product.simplify();
        return product;
    }
};

int main()
{
    int N1, D1, N2, D2, ch = 1;

    cout << "\nEnter the numerator and denominator of first fraction : ";
    cin >> N1 >> D1;
    cout << "\nEnter the numerator and denominator of second fraction : ";
    cin >> N2 >> D2;

    Fractions F1(N1, D1);
    Fractions F2(N2, D2);
    Fractions result(1, 1);

    while (ch != 0)
    {
        cout << "\n----------------------";
        cout << "\nChoose an operation :\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Exit\n\nEnter your choice : ";
        cin >> ch;
        cout << "----------------------";
        switch (ch)
        {
        case 1:
            result = F1 + F2;
            result.print();
            break;

        case 2:
            result = F1 - F2;
            result.print();
            break;

        case 3:
            result = F1 * F2;
            result.print();
            break;

        case 4:
            ch = 0;
            break;

        default:
            cout << "\nInvalid choice!" << endl;
            break;
        }
    }

    return 0;
}