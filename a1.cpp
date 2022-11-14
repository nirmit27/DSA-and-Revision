// Program to compare two numbers

#include<iostream>
using namespace std;

void comp(int a, int b){
    if(a>b){
        cout<<a<<" is greater than "<<b<<endl;
    }
    else if(a<b){
        cout<<b<<" is greater than "<<a<<endl;
    }
    else{
        cout<<a<<" is equal to "<<b<<endl;
    }
}

int main(){
    int a, b;
    cout<<"Enter the first number: ";
    cin>>a;
    cout<<"Enter the second number: ";
    cin>>b;
    comp(a,b);
    getchar();
    return 0;
}