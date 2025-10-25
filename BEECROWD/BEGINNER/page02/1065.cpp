/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    long in, n = 0;

    for (int i=0;i<5;i++){
        if (scanf(" %ld", &in) != 1) return;
        if (in % 2 == 0){
            n++;
        }
    }

    printf("%ld valores pares\n", n);
}