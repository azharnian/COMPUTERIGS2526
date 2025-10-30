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
    hu n, len;
    char word[128];
    if (scanf(" %hu", &n) != 1) return;
    for (hu i=0; i<n; i++){
        if (scanf(" %127s", &word) != 1) return;
        len = strlen(word);
        if (len > 10) printf("%c%hu%c\n", word[0], len-2, word[len-1]);
        else printf("%s\n", word);
    }
}