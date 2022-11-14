// LUCKY NUMBER GAME using recursive approach
#include<iostream>
#include<time.h>

using namespace std;

// Global variable declaration
int lucky_number = time(0) % 10 + 1; // returns a number btw 1-10
int score = 5;

bool playAgain(){
    char ans;
    cout<<"--------------------------"<<endl;
    cout<<"DO YOU WANT TO PLAY AGAIN? (y/n)"<<endl;
    cout<<"--------------------------"<<endl;
    cin>>ans;

    switch (ans)
    {
    case 'y':
        cout<<endl;
        cout<<"Great! Let's give it another try!"<<endl;
        cout<<endl;
        score = 5;
        return true;
        break;
    case 'n':
        cout<<endl;
        cout<<"Thanks for playing! Press Enter to close. :)"<<endl;
        cout<<endl;
        cin.get();
        return false;

    default:
        cout<<endl;
        cout<<"Invalid choice! Please enter your choice again."<<endl;
        cout<<endl;
        playAgain();
        break;
    }
}

bool guessing(){
    int guess;
    cout<<"\n^_^ Guess the lucky number : ^_^ "<<endl;
    cin>>guess;

    if(guess>10 || guess <1){
        cout<<"INVALID GUESS - Please enter a number between 1 and 10 only! :/"<<endl;
        guessing(); // recursion
    }
    else{
        cout<<endl;
        cout<<"So your guess is... "<<guess<<endl;
        cout<<endl;
        if(guess==lucky_number){
            cout<<"YOU GUESSED IT RIGHT AND YOU ARE LUCKY! :D"<<endl;
            cout<<"            CONGRATULATIONS!              ";
            cout<<endl;
            cout<<"YOUR SCORE ON THE LUCKY SCALE --> "<<score<<endl;
            cout<<endl;

            bool answer = playAgain();

            return answer;
        }
        else{
            cout<<"YOU GUESSED IT WRONG AND YOU ARE UNLUCKY! :("<<endl;
            cout<<"TRY AGAIN, YOU UNLUCKY PERSON."<<endl;
            cout<<endl;
            score--;
            cout<<"Chances left --> "<<score<<endl;

            if(score<=0){
                cout<<endl;
                cout<<"YOU LOSE!"<<endl;
                cout<<endl;

                bool answer = playAgain();
                return answer;
            }
            else{
                guessing(); // recursion
            }
        }
    }
}

int main()
{
    cout <<"-----------------------------------------------------------"<<endl;
    cout <<"            WELCOME TO THE LUCKY NUMBER GAME"<<endl;
    cout <<"-----------------------------------------------------------"<<endl;
    cout<<endl;
    cout<<"You have 5 chances to guess the lucky number."<<endl;
    cout<<"The number will be between 1 and 10 ;)"<<endl;
    cout<<"*** Good luck! ***"<<endl;
    cout<<endl;
    cout<<"____________________________________________________________"<<endl;

    bool userChoice = guessing();
    if(userChoice){
        main();
    }
    else{
        cin.get();
    }

    return 0;
}