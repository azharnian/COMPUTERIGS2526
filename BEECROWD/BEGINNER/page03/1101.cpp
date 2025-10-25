/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long n, m, sum;
    while (true){
        if (scanf(" %ld %ld", &n, &m) != 2) return;
        if (n <= 0 || m <= 0) return;
        if (n > m) swap(n, m);
        sum = 0;
        for (long i=n; i<=m; i++) {
            printf("%ld ", i);
            sum += i;
        }
        printf("Sum=%ld\n", sum);
    }
    
    
}