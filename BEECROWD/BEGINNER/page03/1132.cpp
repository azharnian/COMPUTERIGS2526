/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long x, y, sum = 0;
    if (scanf(" %ld\n%ld", &x, &y) != 2) return;
    if (x > y) swap(x, y);
    for (long i = x; i <= y; i++){
        if (i % 13 != 0) sum += i;
    }
    printf("%ld\n", sum);
}