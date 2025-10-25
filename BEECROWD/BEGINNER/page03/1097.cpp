/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    for (int i=1; i<=9; i+=2){
        for (int j=i+6; j>=(i+6)-2; j--){
            printf("I=%d J=%d\n", i, j);
        }
    }
}