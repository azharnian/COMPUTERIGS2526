/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long n, nLine = 0, x = 1;
    if (scanf(" %ld", &n) != 1) return;
    for (int i=0; i<n; i++){
        for (int j=0; j<4; j++){
            if (x%4 != 0) printf("%ld ", x);
            else printf("PUM\n");
            x++;
        }
        nLine++;
    }
}