/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long n, sq, qb;
    if (scanf(" %ld", &n) != 1) return;
    for (int i=1; i<=n; i++){
        sq = i*i, qb = i*i*i;
        printf("%ld %ld %ld\n", i, sq, qb);
        printf("%ld %ld %ld\n", i, sq+1, qb+1);
    }
}