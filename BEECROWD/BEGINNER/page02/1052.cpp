/* Coded by Anas Azhar (anas.sty@gmail.com) */
#include <bits/stdc++.h>
using namespace std;

void solve();

int main(){
    solve();
    return 0;
}

void solve(){
    unordered_map<int, const char*> m = {
        {1, "January"}, {2, "February"}, {3, "March"},
        {4, "April"},   {5, "May"},      {6, "June"},
        {7, "July"},    {8, "August"},   {9, "September"},
        {10, "October"},{11, "November"},{12, "December"}
    };

    int n;
    scanf("%d", &n);
    auto it = m.find(n);
    if (it != m.end()){
        printf("%s\n", it->second);
    }
}