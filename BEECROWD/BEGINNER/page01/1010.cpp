/*
/ Coded by Anas Azhar (anas.sty@gmail.com)
*/
#include <bits/stdc++.h>
using namespace std;
void solution()
{
    double a1, b1, c1, a2, b2, c2;
    cin >> a1 >> b1 >> c1
        >> a2 >> b2 >> c2;

    cout << fixed << setprecision(2)
         << "VALOR A PAGAR: R$ " << (b1 * c1) + (b2 * c2) << "\n";
}
int main(int argc,char *args[])
{
    solution();
    return 0;
}