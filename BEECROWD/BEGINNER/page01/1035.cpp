/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    int A, B, C, D;
    scanf("%d %d %d %d", &A, &B, &C, &D);
    if (B > C && D > A && (C + D) > (A + B) && C > 0 && D > 0 && A % 2 == 0)
        printf("Valores aceitos\n");
    else
        printf("Valores nao aceitos\n");
}