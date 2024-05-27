#include <iostream>

using namespace std;

template <class T> class Complex {

private:
  T re, im;

public:
  Complex(T r, T i) : re(r), im(i) {}

  void display() {
    if (im < 0) {
      cout << re << " - " << -im << "i" << endl;
    } else {
      cout << re << " + " << im << "i" << endl;
    }
  }

  Complex operator+(const Complex<T> &obj) const {
    return Complex(re + obj.re, im + obj.im);
  }

  Complex operator-(const Complex<T> &obj) const {
    return Complex(re - obj.re, im - obj.im);
  }

  Complex operator*(const Complex<T> &obj) const {
    T real = re * obj.re - im * obj.im;
    T imag = re * obj.im + im * obj.re;
    return Complex(real, imag);
  }
};

int main() {
  int a, b;
  cout << endl << "COMPLEX NUMBER OPS." << endl << endl;
  cout << "Enter the components of 1st number : ";
  cin >> a >> b;
  Complex<int> num1(a, b);

  cout << "Enter the components of 2nd number : ";
  cin >> a >> b;
  Complex<int> num2(a, b);

  Complex<int> sum = num1 + num2;
  cout << endl << "Sum : ";
  sum.display();

  Complex<int> diff = num1 - num2;
  cout << endl << "Difference : ";
  diff.display();

  Complex<int> prod = num1 * num2;
  cout << endl << "Product : ";
  prod.display();

  return 0;
}
