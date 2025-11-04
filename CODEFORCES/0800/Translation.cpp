/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    char word1[101], word2[101];
    if (scanf(" %s\n%s", word1, word2) != 2) return;

    short len1=0, len2=0;
    while(word1[len1] != '\0') len1++;
    while(word2[len2] != '\0') len2++;

    if (len1 != len2) {
        printf("NO\n");
        return;
    }

    for (int i = 0; i < len1; i++){
        if (word1[i] != word2[len1 - 1 - i]){
            printf("NO\n");
            return;
        }
    }
    printf("YES\n");
}