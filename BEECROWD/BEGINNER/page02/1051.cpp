/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    double m, m28 = 0, m18 = 0, m08 = 0, t08, t18, t28;
    scanf("%lf", &m);

    if (m > 4500){
        m28 = m - 4500;
        t28 = 0.28 * m28;
    }
    if (m > 3000){
        m18 = m - m28 - 3000;
        t18 = 0.18 * m18;
    }
    if (m > 2000){
        m08 = m - m28 - m18 - 2000;
        t08 = 0.08 * m08;
    }
    if (m <=  2000){
        printf("Isento\n");
        return;
    }

    printf("R$ %.2lf\n", t08+t18+t28);
    return;
}