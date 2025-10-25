/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long n, m;
    while (true){
        if (scanf(" %ld %ld", &n, &m) != 2) return;
        if (n == 0 || m == 0) return;

        if (n > 0 && m > 0) printf("primeiro\n");
        else if (n < 0  && m > 0) printf("segundo\n");
        else if (n < 0 && m < 0) printf("terceiro\n");
        else printf("quarto\n");
    }
}