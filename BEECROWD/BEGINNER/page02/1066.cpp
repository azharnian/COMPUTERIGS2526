/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    long in, nE=0, nO=0, nP=0, nN=0;
    for (int i=0;i<5;i++){
        if (scanf(" %ld", &in) != 1) return;

        if (in % 2 == 0){
            nE++;
        } else {
            nO++;
        }

        if (in > 0){
            nP++;
        } else if(in < 0) {
            nN++;
        }
    }

    printf("%ld valor(es) par(es)\n", nE);
    printf("%ld valor(es) impar(es)\n", nO);
    printf("%ld valor(es) positivo(s)\n", nP);
    printf("%ld valor(es) negativo(s)\n", nN);
}