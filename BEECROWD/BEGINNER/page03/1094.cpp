/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long n, num, nC = 0, nR = 0, nS = 0;
    char animal[8];
    if (scanf(" %ld", &n) != 1) return;
    for (long i=0; i<n; i++){
        if (scanf(" %ld %s", &num, &animal) != 2) return;
        if (strcmp(animal, "C") == 0) nC += num;
        else if (strcmp(animal, "R") == 0) nR += num;
        else if (strcmp(animal, "S") == 0) nS += num;
    }
    long SUM = nC+nR+nS;
    printf("Total: %ld cobaias\n", SUM);
    printf("Total de coelhos: %ld\n", nC);
    printf("Total de ratos: %ld\n", nR);
    printf("Total de sapos: %ld\n", nS);
    printf("Percentual de coelhos: %.2lf %%\n", (double) nC/SUM*100);
    printf("Percentual de ratos: %.2lf %%\n",(double) nR/SUM*100);
    printf("Percentual de sapos: %.2lf %%\n",(double) nS/SUM*100);
}