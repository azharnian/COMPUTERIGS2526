/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

bool isTriangle(double a, double b, double c){
    if (a <= 0 || b <= 0 || c <= 0) return false;
    if (a > b) swap(a, b);
    if (b > c) swap(b, c);
    if (a > b) swap(a, b);
    return a + b > c;
}

void solve(){
    double a, b, c;
    scanf("%lf %lf %lf", &a, &b, &c);
    if (isTriangle(a, b, c)){
        printf("Perimetro = %.1lf\n", (a+b+c));
        return;
    }
    printf("Area = %.1lf\n", ((a+b)*c/2.0));
    return;
}