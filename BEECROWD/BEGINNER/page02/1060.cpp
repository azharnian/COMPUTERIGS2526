/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    double in;
    int ev = 0;
    for (int i=0; i<6; i++){
        if (scanf("%lf", &in) != 1) return;
        if (in > 0.0)
            ev++;
    }
    printf("%d valores positivos\n", ev);
}