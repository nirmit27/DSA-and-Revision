// Program to demonstrate the concept of polymorphisnm implemented in C++
#include <bits/stdc++.h>

using namespace std;

class Shape
{
public:
    string ShapeType;
    Shape(string st)
    { // Constructor
        this->ShapeType = st;
    }
    void printMyType()
    {
        cout << this->ShapeType;
    }
};

class Square : public Shape
{
    int length;

public:
    Square(int l, string st) : Shape(st)
    {
        this->length = l;
    }
    int calculateArea()
    {
        return this->length * this->length;
    }
    void printMyType()
    {
        cout << (this->ShapeType) << endl;
    }
};

class Rectangle : public Shape
{
    int length;
    int breadth;

public:
    Rectangle(int l, int b, string st) : Shape(st)
    {
        this->length = l;
        this->breadth = b;
    }
    int calculateArea()
    {
        return this->length * this->breadth;
    }
    void printMyType()
    {
        cout << (this->ShapeType) << endl;
    }
};

int main()
{

    // Write your code here
    int l1, l2, b2;
    string t1, t2;
    cin >> l1 >> t1;
    cout << endl;
    cin >> l2 >> b2 >> t2;
    Square obj1(l1, t1);
    obj1.printMyType();
    cout << obj1.calculateArea() << endl;
    Rectangle obj2(l2, b2, t2);
    obj2.printMyType();
    cout << obj2.calculateArea() << endl;
    return 0;
}