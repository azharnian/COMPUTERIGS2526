/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    char input[1024];
    while (true){
        if (scanf(" %s", &input) != 1) return;
        if (strcmp(input, "2002") == 0) {
            printf("Acesso Permitido\n");
            return;
        } else 
            printf("Senha Invalida\n");
    }
}