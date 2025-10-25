/*
/ Coded by Anas Azhar (anas.sty@gmail.com)
*/
#include <bits/stdc++.h>
using namespace std;
void solution()
{
    long m;
    cin >> m;
    cout << m  << "\n"
         << m / 100 << " nota(s) de R$ 100,00\n"
         << m % 100 / 50 << " nota(s) de R$ 50,00\n"
         << m % 100 % 50 / 20 << " nota(s) de R$ 20,00\n"
         << m % 100 % 50 % 20 / 10 << " nota(s) de R$ 10,00\n"
         << m % 100 % 50 % 20 % 10 / 5 << " nota(s) de R$ 5,00\n"
         << m % 100 % 50 % 20 % 10 % 5 / 2 << " nota(s) de R$ 2,00\n"
         << m % 100 % 50 % 20 % 10 % 5 % 2 << " nota(s) de R$ 1,00\n";
}
int main(int argc,char *args[])
{
    solution();
    return 0;
}