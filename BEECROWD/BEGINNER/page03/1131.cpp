/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long match = 0, wInter = 0, wGremio = 0, draw = 0;
    long inter, gremio, ans;
    do {
        if (scanf(" %ld %ld", &inter, &gremio) !=2) return;
        match++;
        if (inter > gremio) wInter++;
        if (gremio > inter) wGremio++;
        if (inter == gremio) draw++;

        printf("Novo grenal (1-sim 2-nao)\n");
        if (scanf(" %ld", &ans) != 1) return;
        if (ans == 2) break;
    } while (true);
    printf("%ld grenais\n", match);
    printf("Inter:%ld\n", wInter);
    printf("Gremio:%ld\n", wGremio);
    printf("Empates:%ld\n", draw);
    if (wInter > wGremio) printf("Inter venceu mais\n");
    else if (wInter < wGremio) printf("Gremio venceu mais\n");
    else printf("Não houve vencedor\n");
}