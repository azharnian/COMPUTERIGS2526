/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long n, m;
    if (scanf(" %ld %ld", &n, &m) != 2) return;

    double d = logl((double) m / n) / logl((3.0/2.0));
    long t = (long) floor(d) + 1;

    printf("%ld\n", t);
}