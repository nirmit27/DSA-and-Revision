#include<iostream>

using namespace std;

void patt1(int n){
    int sp = n;
    for(int i=0;i<n;i++){
        for(int k=sp; k>0;k--){
            cout<<" ";
        }
        for(int j=0; j<i; j++){
            cout<<"* ";
        }
        cout<<endl;
        sp--;
    }
}

void patt2(int m){
    for(int i=m;i>0;i--){
        for(int sp=0;sp<m-i;sp++){
            cout<<" ";
        }
        for(int j=0;j<i;j++){
            cout<<"* ";
        }
        cout<<endl;
    }
}

int main(){
    int rows;
    cout<<"Enter the number of rows: ";
    cin>>rows;
    patt1(rows);
    patt2(rows);
    cin.get();
    cin.get();
    return 0;
}