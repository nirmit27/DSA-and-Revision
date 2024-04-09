#include <iostream>
#include <vector>

using namespace std;

void sieve(int n) {
  int count = 0;
  vector<int> isPrime(n + 1, true);

  for (int i = 2; (i * i) <= n; i++) {
    if (isPrime[i]) {
      for (int j = 2 * i; j <= n; j += i)
        isPrime[j] = false;
    }
  }

  for (int k = 2; k <= n; k++) {
    if (isPrime[k]) {
      cout << k << " ";
      count++;
    }
  }
  cout << endl << endl << "Count : " << count << endl;
}

int main() {
  int n;
  cout << "Enter the limit : ";
  cin >> n;

  cout << endl << "All PRIME numbers upto " << n << " are : ";
  sieve(n);

  return 0;
}