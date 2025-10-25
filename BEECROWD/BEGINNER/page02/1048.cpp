/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    double n;
    scanf("%lf", &n);

    double rate;
    if (n <= 400) rate = 0.15;
    else if (n <= 800) rate = 0.12;
    else if (n <= 1200) rate = 0.1;
    else if (n <= 2000) rate = 0.07;
    else rate = 0.04;

    printf("Novo salario: %.2lf\nReajuste ganho: %.2lf\nEm percentual: %.0lf %%\n", n+(n*rate), n*rate, rate*100);
}