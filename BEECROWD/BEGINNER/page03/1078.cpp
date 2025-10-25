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
    for (int i=1; i<=10; i++){
        printf("%d x %ld = %ld\n", i, n, i*n);
    }
}