/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    double p[6] = {0, 4.00, 4.50, 5.00, 2.00, 1.50};

    long n, m;
    scanf("%ld %ld", &n, &m);

    printf("Total: R$ %.2lf\n", p[n]*m);


}