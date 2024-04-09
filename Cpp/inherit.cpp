// Program to demonstrate how inheritance works in C++
#include <bits/stdc++.h>
using namespace std;

// Base class
class Car
{
    int gears;
    string color;

public:
    Car(int nog, string col)
    {
        this->gears = nog;
        this->color = col;
    }
    void printCarInfo()
    {
        cout << "noOfGear: " << this->gears << endl;
        cout << "color: " << this->color << endl;
    }
};

// Derived class via Single-level inheritance
class RaceCar : public Car
{
public:
    int maxSpeed;
    RaceCar(int nog, string col, int mS) : Car(nog, col)
    {
        this->maxSpeed = mS;
    }
    void printRaceCarInfo()
    {
        printCarInfo(); // calling base class method
        cout << "maxSpeed: " << this->maxSpeed << endl;
    }
};

// Driver program
int main(int argc, char const *argv[])
{
    int noOfGear, maxSpeed;
    string color;

    cout << "Enter the number of gears, color and top speed of the car down below!" << endl;
    cin >> noOfGear >> color >> maxSpeed;

    RaceCar racecar(noOfGear, color, maxSpeed);
    racecar.printRaceCarInfo();

    return 0;
}
