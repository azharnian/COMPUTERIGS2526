/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long n;
    double inp1, inp2, inp3, avg;
    if (scanf(" %ld", &n) != 1) return;
    
    for (long i=0; i<n; i++){
        if (scanf(" %lf %lf %lf", &inp1, &inp2, &inp3) != 1);
        avg = (inp1*2 + inp2*3 + inp3*5) / 10;
        printf("%.1lf\n", avg);
    }
}