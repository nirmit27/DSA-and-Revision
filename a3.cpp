#include<iostream>
#include<math.h>

using namespace std;

void area(){ // function to calculate area of the circle
    int r;
    cout<<"Enter the radius of the circle: ";
    cin>>r;
    float circle = 3.14*pow(r,2);
    cout<<"Area of the circle = "<<circle<<" cm^2"<<endl;  
}

void fact(){ // function to calculate the factorial of a number
    int n;
    long factorial = 1.0;

    cout << "Enter a positive integer: ";
    cin >> n;

    if (n < 0)
        cout << "Error! Factorial of a negative number doesn't exist.";
    else {
        for(int i = 1; i <= n; ++i) {
            factorial *= i;
        }
        cout << "Factorial of " << n << " = " << factorial;    
    }
}
 
int main(){
    area();
    fact();
    return 0;
}