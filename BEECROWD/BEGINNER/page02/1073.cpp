/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long n;
    if (scanf(" %ld", &n) != 1) return;
    for (long i=1; i<=n; i++){
        if (i%2==0) printf("%ld^2 = %ld\n", i, i*i);
    }
}