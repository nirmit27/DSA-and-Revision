// Program to count the number of words in a string
#include<bits/stdc++.h>
using namespace std;


int countWords(string input) {
    int spc=1;

    for(int i=0; i<input.length(); i++){
        if(input[i]==' '){
            spc++;
        }
    }

    return spc;
}

int main() {
    string input;
    cout<<"Enter the sentence string: ";
    getline(cin, input);

    cout <<"Number of words = "<<countWords(input)<< endl;

    return 0;
}