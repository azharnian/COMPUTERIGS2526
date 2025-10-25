/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long x, y;
    if (scanf(" %ld\n%ld", &x, &y) != 2) return;

    if (x > y) swap(x, y);
    for (int i=x+1; i<y; i++){
        if (i%5 == 2 || i%5 == 3) printf("%ld\n", i);
    }
}