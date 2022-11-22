// Program to determine the index of first occurence and last occurence of an element in an array
#include<bits/stdc++.h>
using namespace std;

int main()
{
    int i,j,n,x,pos1=-1,pos2=-1;

    cout<<"Enter the array size: ";
    cin>>n;

    int *arr = new int[n];
    
    cout<<"Enter the array: ";
    for(i=0;i<n;i++)
        cin>>*(arr+i);

    cout<<"Enter the element: ";
    cin>>x;
    
    for(i=0;i<n;i++){
        if(*(arr+i)==x){ 
            pos1=i;
            break;
        }
    }

    for(i=0;i<n;i++){
        if(*(arr+i)==x){
            pos2=i;
            continue;
        }
    }

    cout<<"First occurence: "<<pos1<<"\n"<<"Last occurence: "<<pos2<<endl;

    delete [] arr;
    return 0;
}