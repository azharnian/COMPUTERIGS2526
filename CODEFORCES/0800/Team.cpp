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
    hu n, imp = 0, cnt, p, v, t;
    if (scanf(" %hu", &n) != 1) return;
    for (hu i = 0; i < n; i++){
        cnt = 0;
        if (scanf(" %hu %hu %hu", &p, &v, &t) != 3) return;
            cnt  = p + v + t;
            if (cnt > 1) imp++;
    }
    printf("%hu\n", imp);
}