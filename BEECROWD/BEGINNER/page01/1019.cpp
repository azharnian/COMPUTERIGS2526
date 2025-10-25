/*
/ Coded by Anas Azhar (anas.sty@gmail.com)
*/
#include <bits/stdc++.h>
using namespace std;
void solution()
{
    long s;
    cin >> s;
    cout << s/3600 << ":" << s%3600/60 << ":" << s%3600%60 << "\n";
}
int main(int argc,char *args[])
{
    solution();
    return 0;
}