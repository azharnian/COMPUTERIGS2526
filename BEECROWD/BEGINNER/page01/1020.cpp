/*
/ Coded by Anas Azhar (anas.sty@gmail.com)
*/
#include <bits/stdc++.h>
using namespace std;
void solution()
{
    long d;
    cin >> d;
    cout << d/365 << " ano(s)\n"
         << d%365/30 << " mes(es)\n"
         << d%365%30 << " dia(s)\n";  
}
int main(int argc,char *args[])
{
    solution();
    return 0;
}