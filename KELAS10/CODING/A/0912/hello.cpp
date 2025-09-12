#include <iostream>
using namespace std;

int main()
{
    cout << "Hello... what is your name ? ";
    string name;
    cin >> name;

    if (name == "Anas"){
        cout << "Hi.. anas!\n";
        return 0; // OK
    } else {
        return 1;
    }
}