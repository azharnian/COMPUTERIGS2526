/*
/ Coded by Anas Azhar (anas.sty@gmail.com)
*/
#include <bits/stdc++.h>
using namespace std;
void solution()
{
    string n;
    double salary, sold;
    cin >> n >> salary >> sold;

    cout << fixed << setprecision(2) << "TOTAL = R$ " << salary + 0.15 * sold << "\n";
}
int main(int argc,char *args[])
{
    solution();
    return 0;
}