// Program to print all the possible substrings of a given string
#include<bits/stdc++.h>
using namespace std;

void printSubstrings(string input){
    cout<<"Possible sub-strings are as follows: "<<endl;

    for(int i=0; i<input.length(); i++){
        string sub;

        for(int j=i; j<input.length(); j++){
            sub+=input[j];
            cout<<sub<<endl;
        }
    }
}

int main()
{
    cout<<"Enter the string: ";
    string input;
    getline(cin, input);
    
    printSubstrings(input);    
    return 0;
}