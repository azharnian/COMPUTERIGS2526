/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    double n1, n2, n3, n4;
    if (scanf("%lf %lf %lf %lf", &n1, &n2, &n3, &n4) != 4) return;

    double avg = (n1*2.0 + n2*3.0 + n3*4.0 + n4*1.0) / 10.0;
    printf("Media: %.1lf\n", avg);

    if (avg >= 7.0){
        printf("Aluno aprovado.\n");
    } else if (avg < 5.0){
        printf("Aluno reprovado.\n");
    } else {
        printf("Aluno em exame.\n");
        double n5; 
        if (scanf("%lf", &n5) != 1) return;
        printf("Nota do exame: %.1lf\n", n5);

        double new_avg = (avg + n5) / 2.0;
        if (new_avg >= 5.0) printf("Aluno aprovado.\n");
        else                printf("Aluno reprovado.\n");
        printf("Media final: %.1lf\n", new_avg);
    }
}
