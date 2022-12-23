// Rotating an array 'r' steps
#include<bits/stdc++.h>
using namespace std;

void rotate(int *arr, int l,int r){
    int k=0,i;
    int *temp = new int[l];

    for(i=r;i<l;i++){
        *(temp+k)=*(arr+i);
        k++;
    }

    for(i=0;i<r;i++){
        *(temp+k)=*(arr+i);
        k++;
    }
    
    for(i=0;i<l;i++){
        *(arr+i)=*(temp+i);
    }

    delete [] temp;
}

void printArr(int *arr, int l){
    int i;
    cout<<"Rotated array:\n";
    for(i=0;i<l;i++)
        cout<<*(arr+i)<<" ";
}

int main() {
    int i,l,r;
    cout<<"Enter the array size: ";
    cin>>l;

    int *arr = new int[l];
    cout<<"Enter the array: ";
    for(i=0;i<l;i++)
        cin>>*(arr+i);

    cout<<"Enter the number of rotations: ";
    cin>>r;

    rotate(arr,l,r);
    printArr(arr,l);

    delete [] arr;
    return 0;
}