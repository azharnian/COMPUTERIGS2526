/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    unordered_map<long, const char*> ddd = {
        {61, "Brasilia"},
        {71, "Salvador"},
        {11, "Sao Paulo"},
        {21, "Rio de Janeiro"},
        {32, "Juiz de Fora"},
        {19, "Campinas"},
        {27, "Vitoria"},
        {31, "Belo Horizonte"}
    };
    
    int n;
    scanf("%d", &n);
    
    auto it = ddd.find(n);
    if (it != ddd.end())
        printf("%s\n", it->second);
    else 
        printf("DDD nao cadastrado\n");
    
}