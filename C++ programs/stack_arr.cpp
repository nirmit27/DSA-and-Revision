// Implementation of basic stack operations using arrays
#include <bits/stdc++.h>

using namespace std;

// 64-bit Stack implementation
#define MAX 64

// creating a class that defines a stack object
class Stack
{
    int top; // equivalent to stack ptr.

public:
    int arr[MAX]; // max. size of stack

    Stack() { top = -1; }; // Constructor
    bool push(int x);
    int pop();
    int peek();
    bool isEmpty();
};

// push function
bool Stack::push(int x)
{
    if (top >= (MAX - 1))
    {
        cout << "Stack Overflow";
        return false;
    }
    else
    {
        arr[++top] = x;
        cout << x << " pushed into stack\n";
        return true;
    }
}

// pop function
int Stack::pop()
{
    if (top < 0)
    {
        cout << "Stack Underflow";
        return 0;
    }
    else
    {
        int x = arr[top--];
        return x;
    }
}

// peek function
int Stack::peek()
{
    if (top < 0)
    {
        cout << "Stack is empty.";
        return 0;
    }
    else
    {
        int x = arr[top];
        return x;
    }
}

// stack status
bool Stack::isEmpty()
{
    return (top < 0);
}

// driver
int main()
{
    class Stack s1;
    s1.push(10);
    s1.push(20);
    s1.push(30);
    cout << s1.pop() << " popped from stack" << endl;

    cout << "Top element is " << s1.peek() << endl;

    cout << "\nElements present in stack : ";
    while (!s1.isEmpty())
    {
        cout << "\n"
             << s1.peek();
        s1.pop(); // decrements the stack ptr. i.e. top
    }
    return 0;
}
