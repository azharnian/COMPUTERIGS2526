/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    double a, b, c;
    scanf("%lf %lf %lf", &a, &b, &c);

    vector<double> v = {a, b, c};
    sort(v.begin(), v.end(), greater<double>());

    if (v[0] >= v[1] + v[2]){
        printf("NAO FORMA TRIANGULO\n");
        return;
    }

    double A = v[0]*v[0], B = v[1]*v[1], C = v[2]*v[2]; 

    if (A == B + C) printf("TRIANGULO RETANGULO\n");
    else if (A > B + C) printf("TRIANGULO OBTUSANGULO\n");
    else printf("TRIANGULO ACUTANGULO\n");

    if (v[0] == v[1] && v[1] == v[2]) printf("TRIANGULO EQUILATERO\n");
    else if (v[0] == v[1] || v[1] == v[2] || v[0] == v[2]) printf("TRIANGULO ISOSCELES\n");
    return;
}