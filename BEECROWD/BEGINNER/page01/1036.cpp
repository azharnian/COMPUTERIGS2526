/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

bool solve();

int main(){
    solve();
    return 0;
}

bool solve(){
    double A, B, C;
    scanf("%lf %lf %lf", &A, &B, &C);

    if (A == 0.0){
        printf("Impossivel calcular\n");
        return false;
    }
    
    double d = pow(B, 2) - (4 * A * C);
    if (d < 0) {
        printf("Impossivel calcular\n");
        return false;
    }
    double R1 = (-B + sqrt(d))/(2*A);
    double R2 = (-B - sqrt(d))/(2*A);

    printf("R1 = %.5lf\n", R1);
    printf("R2 = %.5lf\n", R2);
    return true;
}