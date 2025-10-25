/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    long n, m;
    scanf("%ld %ld", &n, &m);

    if (n > m) swap(n, m);

    if (m % n == 0) printf("Sao Multiplos\n");
    else printf("Nao sao Multiplos\n");
}