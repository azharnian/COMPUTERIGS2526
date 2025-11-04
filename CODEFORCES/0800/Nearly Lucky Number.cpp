/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
#define ll long long
using namespace std;

void solve();
bool isLucky(ll x);

int main(int argc, char *args[]){
    solve();
    return 0;
}

bool isLucky(ll x) {
    if (x == 0) return false;
    while (x > 0) {
        int d = x % 10;
        if (d != 4 && d != 7) return false;
        x /= 10;
    }
    return true;
}

void solve(){
    ll n, cnt = 0;
    if (scanf(" %lld", &n) != 1) return;

    while (n > 0){
        int ones = n % 10;
        if (ones == 4 || ones == 7) cnt++;
        n /= 10;
    }

    printf(isLucky(cnt) ? "YES\n" : "NO\n");
}