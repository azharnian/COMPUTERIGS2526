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
    hu n, del=0;
    char text[51];
    if (scanf(" %hu %s", &n, text) != 2) return;
    for (int i=0; i+1 < n; i++){
        if (text[i] == text[i+1]) del++;
    }
    printf("%hu\n", del);
}