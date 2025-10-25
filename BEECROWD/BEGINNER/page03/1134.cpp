/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long n, nAl=0, nG=0, nD=0;
    while(true){
        if (scanf(" %ld", &n) != 1) return;
        if (n == 1) nAl++;
        if (n == 2) nG++;
        if (n == 3) nD++;
        if (n == 4) break;
    }
    printf("MUITO OBRIGADO\n");
    printf("Alcool: %ld\n", nAl);
    printf("Gasolina: %ld\n", nG);
    printf("Diesel: %ld\n", nD);
}