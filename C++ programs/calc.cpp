// Calculator using C++
#include<bits/stdc++.h>

using namespace std;

void add(){
    cout<<"\nEnter the numbers : ";
    int x,y;
    cin>>x>>y;
    cout<<"Sum : "<<x+y<<"\n"<<endl;
}

void sub(){
    cout<<"\nEnter the numbers : ";
    int x,y;
    cin>>x>>y;
    cout<<"Difference : "<<x-y<<"\n"<<endl;
}

void mul(){
    cout<<"\nEnter the numbers : ";
    int x,y;
    cin>>x>>y;
    cout<<"Product : "<<x*y<<"\n"<<endl;
}

void div(){
    cout<<"\nEnter the numbers : ";
    float x,y;
    cin>>x>>y;
    cout<<"Quotient : "<<x/y<<"\n"<<endl;
}

void fact(){
    int n;
    cout<<"\nEnter a number : ";
    cin>>n;
    long f = 1;
    for(int i=1;i<=n;i++){
        f*=i;
    }
    cout<<"Factorial of "<<n<<" = "<<f<<"\n"<<endl;
}

void pwr(){
    int a,b;
    cout<<"\nEnter the number and it's power : ";
    cin>>a>>b;
    float res = pow(a,b);
    cout<<a<<" raised to "<<b<<" = "<<res<<"\n"<<endl;
}

void sqr(){
    int a;
    cout<<"\nEnter the number : ";
    cin>>a;
    float res = pow(a,2);
    cout<<"Square of "<<a<<" = "<<res<<"\n"<<endl;
}

void cub(){
    int a;
    cout<<"\nEnter the number : ";
    cin>>a;
    float res = pow(a,3);
    cout<<"Cube of "<<a<<" = "<<res<<"\n"<<endl;
}

void sqroot(){
    int a;
    cout<<"\nEnter the number : ";
    cin>>a;
    float res = pow(a,0.5);
    cout<<"Square root of "<<a<<" = "<<res<<"\n"<<endl;
}

int main(){
    int ch;
    cout<<"---------------------"<<"\n"<<endl;
    cout<<"Choose the operation:\n'1' - ADD\n'2' - SUBTRACT\n'3' - MULTIPLY\n'4' - DIVIDE\n'5' - FACTORIAL\n'6' - POWER\n'7' - SQUARE\n'8' - CUBE\n'9' - SQUARE ROOT\n'0' - EXIT"<<"\n"<<endl;
    cout<<"---------------------"<<"\n"<<endl;
    while(1){
        cin>>ch;
        switch(ch){
            case 1:
            add();
            break;
            case 2:
                sub();
                break;
            case 3:
                mul();
                break;
            case 4:
                div();
                break;
            case 5:
                fact();
                break;
            case 6:
                pwr();
                break;
            case 7:
                sqr();
                break;
            case 8:
                cub();
                break;
            case 9:
                sqroot();
                break;
            case 0:
                exit(0);
                break;
            default:
                cout<<"\nEnter a valid operation."<<"\n"<<endl;
        }
    }
    return 0;
}