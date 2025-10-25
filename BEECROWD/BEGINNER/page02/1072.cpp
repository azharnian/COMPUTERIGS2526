/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    int n, inp, in=0, out=0;
    scanf(" %d", &n);
    for (int i = 0; i < n; i++){
        if (scanf(" %d", &inp) != 1) return;

        if (inp >= 10 && inp <= 20)
            in++;
        else out++;
    }
    printf("%d in\n%d out\n", in, out);
}