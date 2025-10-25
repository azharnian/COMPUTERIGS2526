/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long n, pos, max;
    for (int i=1; i<=100; i++){
        if (scanf(" %ld", &n) != 1) return;
        if (i == 1) {
            pos = i;
            max = n;
            continue;
        }
        if (n > max) {
            max = n;
            pos = i;
        }
    }
    printf("%ld\n%ld\n", max, pos);
}