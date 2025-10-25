/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long nValid = 0;
    double n, sum = 0.0;
    while (nValid != 2){
        if (scanf(" %lf", &n) != 1) return;
        if (n >= 0 && n <= 10) {
            sum += n;
            nValid++;
        }
        else printf("nota invalida\n");
    }
    printf("media = %.2lf\n", sum/nValid);
}