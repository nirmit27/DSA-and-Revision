// Program to find the peak element in an array
#include <bits/stdc++.h>
using namespace std;

int findPeak(int* arr, int n)
{
	if (n == 1)
		return 0;
	if (*(arr+0) >= *(arr+1)) // in case the first element is the peak element
		return 0;
	if (*(arr+(n - 1)) >= *(arr+(n - 2))) // in case the last element is the peak element
		return n - 1;

	for (int i = 1; i < n - 1; i++) { // // in case an intermediate element is the peak element
		if (*(arr+i)>= *(arr+(i - 1)) && *(arr+i) >= *(arr+(i + 1)))
			return i;
	}
}

int main()
{
    int res,n,i;
    cout<<"Enter the size: ";
    cin>>n;

    int *arr = new int[n];
    cout<<"Enter the array: ";
    for(i=0;i<n;i++)
        cin>>*(arr+i);

    res = findPeak(arr,n);
    cout<<"Index of peak element: "<<res;

    delete [] arr;
	return 0;
}
