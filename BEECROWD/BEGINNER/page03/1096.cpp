/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    for (int i=1; i<= 9; i+=2){
        for (int j=7; j>=5; j--){
            printf("I=%d J=%d\n", i, j);
        }
    }
}