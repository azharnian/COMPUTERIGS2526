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
    hu n, m;
    if (scanf(" %hu %hu", &n, &m) != 2) return;
    printf("%hu\n", n*m/2);
}