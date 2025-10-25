/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    bool done = false;
    long nValid, ans;
    double in, sum;
    do {
        if (!done){
            nValid = 0, sum = 0;;
            while(nValid != 2){
                if (scanf(" %lf", &in) != 1) return;
                if (in >= 0 && in <= 10) {
                    sum += in;
                    nValid++;
                } else printf("nota invalida\n");
            }
            printf("media = %.2lf\n", sum/nValid);
            done = true;
        }
        printf("novo calculo (1-sim 2-nao)\n");
        if (scanf(" %ld", &ans) != 1) return;
        if (ans == 2) return;
        else if (ans == 1) done = false;
    } while (true);
}