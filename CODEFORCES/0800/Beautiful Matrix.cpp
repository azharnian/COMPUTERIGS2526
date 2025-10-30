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
    hu X, Y, inp;

    for (hu i=1; i<= 5; i++){
        for (hu j=1; j<=5; j++){
            if (scanf(" %hu", &inp) != 1) return;

            if (inp == 1) {
                X = i;
                Y = j;
            }
        }
    }

    hu move = abs(X - 3) + abs(Y - 3);
    printf("%hu\n", move);
}