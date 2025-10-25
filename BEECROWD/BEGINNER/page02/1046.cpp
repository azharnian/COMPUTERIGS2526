/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    long i, f, d;
    scanf("%ld %ld", &i, &f);
    if (f > i)
        d = f-i;
    else if (f == i)
        d = 24;
    else
        d = 24 - i + f;
    printf("O JOGO DUROU %ld HORA(S)\n", d);
}