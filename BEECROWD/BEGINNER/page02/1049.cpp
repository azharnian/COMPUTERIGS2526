/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    char s1[32], s2[32], s3[32];
    scanf("%31s", s1);
    scanf("%31s", s2);
    scanf("%31s", s3);

    if (strcmp(s1, "vertebrado") == 0) {
        if (strcmp(s2, "ave") == 0) {
            if (strcmp(s3, "carnivoro") == 0) printf("aguia\n");
            else if (strcmp(s3, "onivoro") == 0) printf("pomba\n");
        } else if (strcmp(s2, "mamifero") == 0) {
            if (strcmp(s3, "onivoro") == 0) printf("homem\n");
            else if (strcmp(s3, "herbivoro") == 0) printf("vaca\n");
        }
    } else if (strcmp(s1, "invertebrado") == 0) {
        if (strcmp(s2, "inseto") == 0) {
            if (strcmp(s3, "hematofago") == 0) printf("pulga\n");
            else if (strcmp(s3, "herbivoro") == 0) printf("lagarta\n");
        } else if (strcmp(s2, "anelideo") == 0) {
            if (strcmp(s3, "hematofago") == 0) printf("sanguessuga\n");
            else if (strcmp(s3, "onivoro") == 0) printf("minhoca\n");
        }
    }
}