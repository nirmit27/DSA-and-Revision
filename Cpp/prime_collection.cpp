// Class for printing the prime numbers from a given set of integers ...
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

class CollectPrimes{
    private:
        vector<int> numbers;

        bool isPrime(int n) const {
            if(n < 2) return false;
            if(n == 2) return true;
            if(n%2 == 0) return false;
            
            for(int i=3; i<=sqrt(n); i+=2){
                if(n%i == 0) return false;
            }
            
            return true;
        }

    public:
        CollectPrimes(const vector<int>& nums): numbers(nums) {}

        void printPrimes() const{
            bool noPrime = true;
            cout << endl << "Prime integers in the collection : ";
            
            for(int n: numbers){
                if(isPrime(n)){
                    cout << n << " ";
                    noPrime = false;
                }
            }
            if(noPrime) cout << "None" << endl;
        }
};

int main(){
    int n;
    cout << "Enter the number of integers : ";
    cin >> n;
    
    vector<int> nums;
    nums.reserve(n);
    
    cout << endl << "Enter the integers : ";
    for(int i=0; i<n; i++){
        int x;
        cin >> x;
        nums.push_back(x);
    }
    
    CollectPrimes primes = CollectPrimes(nums);
    primes.printPrimes();
    
    return 0;
}
