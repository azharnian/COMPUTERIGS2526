/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long i = 1, j = 60;
    while (j >= 0){
        printf("I=%ld J=%ld\n", i, j);
        i += 3;
        j -= 5;
    }
}