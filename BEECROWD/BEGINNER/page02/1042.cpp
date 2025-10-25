/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    vector<long> a(3);
    scanf("%ld %ld %ld", &a[0], &a[1], &a[2]);

    vector<long> b = a;                 
    sort(b.begin(), b.end()); 

    for (auto x : b) printf("%ld\n", x);
    printf("\n");
    for (auto x : a) printf("%ld\n", x);
}