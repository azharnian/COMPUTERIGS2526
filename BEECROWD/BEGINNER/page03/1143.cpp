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
    for (int i=1; i<=n; i++){
        printf("%ld %ld %ld\n", i, i*i, i*i*i);
    }
}