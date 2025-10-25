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
    for (long i=1; i<=10000; i++){
        if (i%n == 2){
            printf("%d\n", i);
        }
    }
}