/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    long Hi, Mi, Hf, Mf, dH, dM;
    scanf("%ld %ld %ld %ld", &Hi, &Mi, &Hf, &Mf);
    
    if (Hi == Hf && Mi == Mf){
        dH = 24; dM = 0;
        printf("O JOGO DUROU %ld HORA(S) E %ld MINUTO(S)\n", dH, dM);
        return;
    } else if(Hi == Hf && Mf > Mi) {
        dH = 0; dM = Mf - Mi;
        printf("O JOGO DUROU %ld HORA(S) E %ld MINUTO(S)\n", dH, dM);
        return;
    }
    if (Hf > Hi){
        if (Mf >= Mi){
            dH = Hf - Hi; dM = Mf - Mi;
        } else {
            dH = Hf - Hi - 1; dM = 60 - Mi + Mf;
        }
    } else {
        if (Mf >= Mi){
            dH = 24 - Hi + Hf; dM = Mf - Mi;
        } else {
            dH = 24 - Hi + Hf - 1; dM = 60 - Mi + Mf;
        }
    }
    printf("O JOGO DUROU %ld HORA(S) E %ld MINUTO(S)\n", dH, dM);
    return;
}