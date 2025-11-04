/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    char n[1024];
    if (scanf(" %s", &n) != 1) return;
    if (n[0] >= 97)
        n[0] = n[0] - 32;
    printf("%s\n", n);
}