/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    short n, X=0;
    char bitland[4];
    if (scanf(" %hd", &n) != 1) return;
    for (short i=0; i<n; i++){
        if (scanf(" %3s", &bitland) != 1) return;
        if (bitland[0] == '+' || bitland[2] == '+') X++;
        else X--;
    }
    printf("%hd\n", X);
}