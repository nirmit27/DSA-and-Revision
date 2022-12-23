// Program to demonstrate the types of constructors and methods in OOP
#include <bits/stdc++.h>
using namespace std;

class student
{
    int r_no;
    string name;

public:
    student(int roll, string name)
    { // parameterized constructor
        this->r_no = roll;
        this->name = name;
    }

    student(student &obj)
    { // copy constructor
        r_no = obj.r_no;
        name = obj.name;
    }

    void display()
    {
        cout << this->r_no << " " << this->name << endl;
    }

    int add(student *);

    ~student()
    { // destructor
        cout << "The destructor is here!!!" << endl;
    }
};

int student::add(student *obj)
{                            // defining a member fn. outside the class
    return r_no + obj->r_no; // dereferencing the pointer requires the arrow "->" operator
}

/*
In case of pass by reference, the declaration of the member function:-
    int add(student &);
and the corresponding definition will be as follows:-
    int student::add(student &obj){
        return r_no+obj.r_no;
    }
In that case, the function call will recieve:-
    add(guy1)
*/

int main()
{
    student guy1(21, "Krishna");
    student guy2(27, "Nirmit");

    guy1.display();
    guy2.display();
    cout << guy2.add(&guy1) << endl;

    return 0;
}