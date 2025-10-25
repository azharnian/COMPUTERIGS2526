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

    long x, y;
    double res;
    for (int i=0; i<n; i++){
        if (scanf(" %ld %ld", &x, &y) != 2) return;
        if (y == 0) {
            printf("divisao impossivel\n");
            continue;
        }
        res = (double) x / y;
        printf("%.1lf\n", res);
    }
}