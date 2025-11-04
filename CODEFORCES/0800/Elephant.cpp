/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    int n;
    if (scanf(" %d", &n) != 1) return;
    printf("%d\n", (n+4)/5); // ceil(x/d) = (x + d - 1)/d   // >.<
}