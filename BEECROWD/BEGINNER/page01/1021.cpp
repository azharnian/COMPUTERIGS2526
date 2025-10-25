/*
/ Coded by Anas Azhar (anas.sty@gmail.com)
*/
#include <bits/stdc++.h>
using namespace std;
void solution()
{
    double m;
    cin >> m;
    long intM = (long) llround(m * 100.0);
    cout << "NOTAS:\n"
         << intM/10000 << " nota(s) de R$ 100.00\n"
         << intM%10000/5000 << " nota(s) de R$ 50.00\n"
         << intM%10000%5000/2000 << " nota(s) de R$ 20.00\n"
         << intM%10000%5000%2000/1000 << " nota(s) de R$ 10.00\n"
         << intM%10000%5000%2000%1000/500 << " nota(s) de R$ 5.00\n"
         << intM%10000%5000%2000%1000%500/200 << " nota(s) de R$ 2.00\n"
         << "MOEDAS:\n"
         << intM%10000%5000%2000%1000%500%200/100 << " moeda(s) de R$ 1.00\n"
         << intM%10000%5000%2000%1000%500%200%100/50 << " moeda(s) de R$ 0.50\n"
         << intM%10000%5000%2000%1000%500%200%100%50/25 << " moeda(s) de R$ 0.25\n"
         << intM%10000%5000%2000%1000%500%200%100%50%25/10 << " moeda(s) de R$ 0.10\n"
         << intM%10000%5000%2000%1000%500%200%100%50%25%10/5 << " moeda(s) de R$ 0.05\n"
         << intM%10000%5000%2000%1000%500%200%100%50%25%10%5 << " moeda(s) de R$ 0.01\n";

}
int main(int argc,char *args[])
{
    solution();
    return 0;
}