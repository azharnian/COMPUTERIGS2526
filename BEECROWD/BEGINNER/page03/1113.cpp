/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long x, y;
    while (true){
        if (scanf(" %ld %ld", &x, &y) != 2) return;
        if (x == y) return;
        if (x > y) 
            printf("Decrescente\n");
        else 
            printf("Crescente\n");
    }
}