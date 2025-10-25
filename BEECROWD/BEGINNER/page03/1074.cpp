/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    long n, inp;
    if (scanf(" %ld", &n) != 1) return;
    for (long i=0; i<n; i++){
        if (scanf(" %ld", &inp) != 1) return;

        if (inp == 0) { 
            printf("NULL\n");
        } else {
            if (inp % 2 == 0){
                printf("EVEN ");
            } else {
                printf("ODD ");
            }

            if (inp > 0){
                printf("POSITIVE\n");
            } else {
                printf("NEGATIVE\n");
            }
        }    
    }
}