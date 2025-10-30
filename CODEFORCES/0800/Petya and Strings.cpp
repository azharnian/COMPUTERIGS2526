/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
#define hc unsigned char
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void toLowerInPlace(char s[]) {
    for (int i = 0; s[i] != '\0'; i++) {
        s[i] = tolower((hc)s[i]);
    }
}

void solve(){
    char n[101], m[101];
    if (scanf(" %100s\n%100s", &n, &m) != 2) return;

    toLowerInPlace(n);
    toLowerInPlace(m);

    int cmp = strcmp(n, m);
    if (cmp < 0)
        printf("-1\n");
    else if(cmp > 0)
        printf("1\n");
    else
        printf("0\n");
}