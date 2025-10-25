/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long x, y, sum=0;
    if (scanf(" %ld", &x) != 1) return;
    if (scanf(" %ld", &y) != 1) return;

    if (x > y) swap(x, y);
    for (long i = x+1; i < y; i++){
        if (i%2!=0) {
            sum+=i;
        };
    }
    printf("%ld\n", sum);
}