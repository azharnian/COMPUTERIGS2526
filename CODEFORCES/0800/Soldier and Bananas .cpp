/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long k, n, w;
    if (scanf(" %ld %ld %ld", &k, &n, &w) != 3) return;
    long p = k * (w * (w+1)/2);  // k * w * (w+1) / 2 (deretnya)
    long b = p > n ? p - n : 0;
    printf("%ld\n", b);
}