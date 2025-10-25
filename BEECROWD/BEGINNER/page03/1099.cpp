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
    long x, y, sum;
    for (long i=0; i<n; i++){
        if (scanf(" %ld %ld", &x, &y) != 2) return;
        sum = 0;
        if (x > y) swap(x, y);
        for (long i=x+1; i<y; i++){
            if (i%2 != 0) sum += i;
        }
        printf("%ld\n", sum);
    }
}