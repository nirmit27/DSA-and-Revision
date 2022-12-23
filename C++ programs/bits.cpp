// Program to count the numcounter of 1's in the binary representation of any number
#include <bits/stdc++.h> 
#include <iostream>

using namespace std;

int countBits(int n){
    int count=0;
    while(n){
        count+=n&1;
        n>>=1;
    }
    return count;
}

int main() {
    int n;
    cout<<"Enter the number: ";
    cin >> n;
    cout<<countBits(n);
    return 0;
}