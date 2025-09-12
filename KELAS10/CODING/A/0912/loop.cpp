#include <iostream>
#include <vector>
using namespace std;

int main()
{
    for(int i = 0; i < 10; i += 2)
    {
        cout << i << endl;
    }
    
    int scores[3] = {90, 100, 80};

    for (int score : scores)
    {
        cout << score << endl;
    }

    vector<string> students = {"Anas", "Budi", "Cindy"};

    for (string student : students) // friend ini keyword
    {
        cout << student << endl;
    }

    string teachers[3] = {"A", "B", "C"};

    for (string teacher : teachers)
    {
        cout << teacher << endl;
    }
}