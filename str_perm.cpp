// Program to check whether two strings are permutations of each other
#include <bits/stdc++.h> 
using namespace std;

bool isPermutation(char input1[], char input2[]) {
    int frequency[256];

    for (int i = 0; i < 256; ++i) {
        frequency[i] = 0;
    }

    for (int i = 0; (input1[i] != '\0')||(input2[i] != '\0'); ++i) {
        ++frequency[input1[i]];
        --frequency[input2[i]];
    }
    
    for (int i = 0; i < 256; ++i) {
        if (frequency[i] != 0) {
            return false;
        }
    }
    return true;
}

int main() {
    int size = 1e6;
    char str1[size];
    char str2[size];
    cout<<"Are they permutations of each other? : ";
    cin >> str1 >> str2;
    cout << (isPermutation(str1, str2) ? "true" : "false");
}