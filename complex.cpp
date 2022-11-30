// Program to calculate the sum and product of two complex numbers using OOP approach
#include <bits/stdc++.h>

using namespace std;

class ComplexNumbers
{
    int real;
    int img;

public:
    ComplexNumbers(int r, int i)
    {
        real = r;
        img = i;
    }
    void plus(ComplexNumbers obj)
    {
        real += obj.real;
        img += obj.img;
    }
    void multiply(ComplexNumbers obj)
    {
        int res1 = real * (obj.real) - img * (obj.img);
        int res2 = real * (obj.img) + img * (obj.real);
        real = res1;
        img = res2;
    }
    void print()
    {
        if (img >= 0)
        {
            cout << real << " + i" << img;
        }
        else
        {
            cout << real << " - i" << abs(img);
        }
    }
};

int main()
{
    int real1, imaginary1, real2, imaginary2;

    cout<<"Enter the first complex number: ";
    cin >> real1 >> imaginary1;
    cout<<"Enter the second complex number: ";
    cin >> real2 >> imaginary2;

    ComplexNumbers c1(real1, imaginary1);
    ComplexNumbers c2(real2, imaginary2);

    int choice;
    cout<<"Enter your choice of operation: 1) Sum\t2) Product\n>> ";
    cin >> choice;

    if (choice == 1)
    {
        c1.plus(c2);
        cout<<"Sum = ";
        c1.print();
    }
    else if (choice == 2)
    {
        c1.multiply(c2);
        cout<<"Product = ";
        c1.print();
    }
    else
    {
        return 0;
    }
}