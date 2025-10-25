/* Coded by Anas Azhar (anas.sty@gmail.com) */
// [0,25] (25,50] (50,75] (75,100]
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    double n;
    if (scanf("%lf", &n) != 1) return;

    if (n >= 0.0 && n <= 25.0)
        printf("Intervalo [0,25]\n");
    else if (n > 25.0 && n <= 50.0)
        printf("Intervalo (25,50]\n");
    else if (n > 50.0 && n <= 75.0)
        printf("Intervalo (50,75]\n");
    else if (n > 75.0 && n <= 100.0)
        printf("Intervalo (75,100]\n");
    else
        printf("Fora de intervalo\n");
}
