/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
#define hu unsigned short
using namespace std;

void solve();

int main(int argc, char *args[]){
    solve();
    return 0;
}

void solve(){
    hu n, k, inp, lim, nP = 0;
    vector<hu> nums;
    if (scanf(" %hu %hu", &n, &k) != 2) return;
    for (hu i = 1; i <= n; i++){
        if (scanf(" %hu", &inp) != 1) return;
        nums.push_back(inp);
        if (i == k) lim = inp;
    }

    for (hu x : nums){
        if (x > 0 && x >= lim) nP++;
    }
    printf("%hu\n", nP);
}