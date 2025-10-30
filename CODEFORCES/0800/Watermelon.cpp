/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
#define hu unsigned short
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    hu n;
    if (scanf(" %hu", &n) != 1) return;
    if (n % 2 == 0 && n >= 4) printf("YES\n");
    else printf("NO\n");
}