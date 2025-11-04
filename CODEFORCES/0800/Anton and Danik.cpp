/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    int n, A = 0, D = 0;
    char wins[100001];
    if (scanf(" %d\n%s", &n, wins) != 2) return;

    for (char &c : wins){
        if (c == '\0') break;
        if (c == 'A') A++;
        else D++;
    }

    if (A > D) printf("Anton\n");
    else if (D > A) printf("Danik\n");
    else printf("Friendship\n");
}
