/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc,char *args[]){
    solve();
    return 0;
}

void solve(){
    int n;
    if (scanf(" %d", &n) != 1) return;
    for (int i=0; i<6; i++){
        if (n%2!=0) printf("%d\n", n+i*2);
        else printf("%d\n", (n+1)+i*2);
    }
}