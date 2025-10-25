/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    double i, j, off = 0;
    for (int step=0; step<=10; step++){
        
        if (step % 5 == 0 && step > 0) off++;
        i = step * 0.2;
        for (int base=1; base<=3; base++){
            j = base + (i - (int)i) + off;
            if(i == (int)i) printf("I=%.0lf J=%.0lf\n", i, j);
            else printf("I=%.1lf J=%.1lf\n", i, j);
        }
        
    }
}