// Operator Overloading
#include <bits/stdc++.h>
using namespace std;

class Polynomial // class for operating on Polynomials
{
public:
    int *degCoeff;
    int capacity;

    Polynomial() // Constructor
    {
        degCoeff = new int[10];
        capacity = 10;               // Hard-coded value of capacity
        for (int i = 0; i < 10; i++) // Initialising all the coefficients with 0 by default
            degCoeff[i] = 0;
    }

    Polynomial(Polynomial const &obj) // Copy Constructor
    {
        delete[] degCoeff;
        degCoeff = new int[obj.capacity];
        for (int i = 0; i < obj.capacity; i++)
            degCoeff[i] = obj.degCoeff[i];
        capacity = obj.capacity;
    }

    void print() // Printing only non-zero coefficient terms
    {
        for (int i = capacity - 1; i >= 0; i--)
        {
            if (degCoeff[i] != 0)
            {
                cout << degCoeff[i] << "x" << i << ' ';
            }
        }
        cout << endl;
    }

    // Setting the values of the coefficients
    void setCoeff(int deg, int coeff)
    {
        if (deg >= capacity) // in case the degree exceeds the hard-coded value of capacity
        {
            int size = 2 * capacity;
            while (size <= deg)
                size *= 2;

            int *newDegCoeff = new int[size];
            for (int i = 0; i < size; i++)
                newDegCoeff[i] = 0;

            for (int i = 0; i < capacity; i++)
                newDegCoeff[i] = degCoeff[i];

            capacity = size;
            delete[] degCoeff;
            degCoeff = newDegCoeff;
        }
        degCoeff[deg] = coeff; // assigning the coefficient value
    }

    // Operator Overloading starts here!!!
    void operator=(Polynomial const &p)
    {
        delete[] degCoeff;
        degCoeff = new int[p.capacity];
        for (int i = 0; i < p.capacity; i++)
            degCoeff[i] = p.degCoeff[i];
        capacity = p.capacity;
    }

    Polynomial operator+(Polynomial const &p)
    {
        Polynomial sum;
        int i = 0, j = 0;
        while (i < this->capacity && j < p.capacity)
        {
            int deg = i;
            int coeff = this->degCoeff[i] + p.degCoeff[j];
            sum.setCoeff(deg, coeff);
            i++;
            j++;
        }
        while (i < capacity)
        {
            sum.setCoeff(i, degCoeff[i]);
            i++;
        }
        while (j < p.capacity)
        {
            sum.setCoeff(j, degCoeff[j]);
            j++;
        }
        return sum;
    }

    Polynomial operator-(Polynomial const &q)
    {
        Polynomial diff;
        int i = 0, j = 0;
        while (i < capacity && j < q.capacity)
        {
            int deg = i;
            int coeff = this->degCoeff[i] - q.degCoeff[j];
            diff.setCoeff(deg, coeff);
            i++;
            j++;
        }
        while (i < capacity)
        {
            diff.setCoeff(i, degCoeff[i]);
            i++;
        }
        while (j < q.capacity)
        {
            diff.setCoeff(j, (-1 * q.degCoeff[j]));
            j++;
        }
        return diff;
    }

    // returning the coefficient corresponding to a certain degree
    int getCoeff(int degree)
    {
        if (degree >= capacity)
            return 0;
        return degCoeff[degree];
    }

    Polynomial operator*(const Polynomial &r)
    {
        Polynomial prod;

        for (int j = 0; j < r.capacity; j++)
        {
            for (int i = 0; i < capacity; i++)
            {
                int deg = i + j;
                int coeff = prod.getCoeff(deg) + (this->degCoeff[i] * r.degCoeff[j]);
                prod.setCoeff(deg, coeff);
            }
        }
        return prod;
    }
};

// Driver program
int main(int argc, char const *argv[])
{
    int n1, n2, ch = 10;

    // First Polynomial input
    cout << "\n\t\t\t THE POLYNOMIAL PROGRAM";
    cout << "\n-----------------------------------------------------------------------------";
    cout << "\nEnter the number of terms in the first polynomial : ";
    cin >> n1;
    cout << "\nEnter the coefficients and degrees of the first polynomial down below : " << endl;

    int *degree1 = new int[n1];
    int *coeff1 = new int[n1];
    for (int i = 0; i < n1; i++)
    {
        cin >> coeff1[i] >> degree1[i];
    }
    Polynomial first;
    for (int i = 0; i < n1; i++)
        first.setCoeff(degree1[i], coeff1[i]);

    // Second Polynomial input
    cout << "\nEnter the number of terms in the second polynomial : ";
    cin >> n2;
    cout << "\nEnter the coefficients and degrees of the second polynomial down below : " << endl;

    int *degree2 = new int[n2];
    int *coeff2 = new int[n2];
    for (int i = 0; i < n2; i++)
    {
        cin >> coeff2[i] >> degree2[i];
    }
    Polynomial second;
    for (int i = 0; i < n2; i++)
        second.setCoeff(degree2[i], coeff2[i]);

    // Example
    // Polynomial sample;
    // sample.print();

    // Displaying the menu...
    while (ch != 5)
    {
        cout << "\n--------MENU--------" << endl;
        cout << "1. Add" << endl;
        cout << "2. Subtract" << endl;
        cout << "3. Multiply" << endl;
        cout << "4. Copy" << endl;
        cout << "5. Exit" << endl;
        cout << "--------------------" << endl;
        cout << "Enter your choice of operation : ";
        cin >> ch;
        if (ch == 5)
            break;
        cout << endl;
        cout << "Result : " << endl;
        Polynomial result;
        switch (ch)
        {
        case 1:
            result = first + second;
            result.print();
            break;

        case 2:
            result = first - second;
            result.print();
            break;

        case 3:
            result = first * second;
            result.print();
            break;

        case 4:
            int flag = 0;
            Polynomial third = first;
            Polynomial fourth(second);
            for (int i = 0; (i < third.capacity && i < fourth.capacity); i++)
            {
                if ((third.degCoeff[i] != first.degCoeff[i]) && (fourth.degCoeff[i] != second.degCoeff[i]))
                    flag++;
                break;
            }
            if (flag == 0)
            {
                cout << "Copied successfully!" << endl;
                third.print();
                fourth.print();
            }
            else
                cout << "Copy operation failed!" << endl;
            break;
        }
        cout << "\nEnter 5 to exit.\nEnter any number to continue." << endl;
        cin >> ch;
    }
    cout << "\n_____________________________________________________________________________";
    return 0;
}