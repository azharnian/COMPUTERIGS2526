/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    long Di, Hi, Mi, Si, Df, Hf, Mf, Sf, dD, dH, dM, dS;
    scanf(" Dia %ld", &Di);
    scanf(" %ld : %ld : %ld", &Hi, &Mi, &Si);
    scanf(" Dia %ld", &Df);
    scanf(" %ld : %ld : %ld", &Hf, &Mf, &Sf);

    dD = Df - Di;
    dH = Hf - Hi;
    dM = Mf - Mi;
    dS = Sf - Si;

    if (dS < 0) { dS += 60; dM--; }
    if (dM < 0) { dM += 60; dH--; }
    if (dH < 0) { dH += 24; dD--; }

    printf("%ld dia(s)\n", dD);
    printf("%ld hora(s)\n", dH);
    printf("%ld minuto(s)\n", dM);
    printf("%ld segundo(s)\n", dS);
}