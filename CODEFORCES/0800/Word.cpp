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
    char word[101];
    hu l = 0, u = 0;
    if (scanf(" %s", word) != 1) return;
    for (char &c : word){
        if (c == 0) break;
        if (c >= 97) l++;
        else u++;
    }
    if (u > l){
        for (char &c : word){
            if (c == 0) break;
            if (c >= 97) c -= 32;
        }
    } else {
        for (char &c : word){
            if (c == 0) break;
            if (c < 97) c += 32;
        }
    }
    printf("%s\n", word);
}