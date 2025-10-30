/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    char name[101];
    if (scanf(" %100s", name) != 1) return;

    set<char> d;
    for (int i = 0; name[i] != '\0'; i++) {
        d.insert(name[i]);
    }

    if (d.size() % 2 == 0)
        printf("CHAT WITH HER!\n");
    else
        printf("IGNORE HIM!\n");
}