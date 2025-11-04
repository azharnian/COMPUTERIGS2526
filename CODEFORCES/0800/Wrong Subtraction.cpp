/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    int n, k;
    if (scanf(" %d %d", &n, &k) != 2) return;

    short ones;
    for (int i = 0; i < k; i++){
        ones = n%10;
        if (ones > 0) n--;
        else n /= 10;
    }
    printf("%d\n", n);
}