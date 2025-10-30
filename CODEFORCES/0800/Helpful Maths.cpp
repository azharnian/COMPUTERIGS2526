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
    hu nums[4] = {0, 0, 0, 0};
    char txt[101], out[101] = "";
    if (scanf(" %s", txt) != 1) return;
    for (char c : txt){
        if (c == '1') nums[1]++;
        if (c == '2') nums[2]++;
        if (c == '3') nums[3]++;
    }

    for (hu i = 0; i < nums[1]; i++){
        strcat(out, "1+");
    }

    for (hu i = 0; i < nums[2]; i++){
        strcat(out, "2+");
    }

    for (hu i = 0; i < nums[3]; i++){
        strcat(out, "3+");
    }
    hu len = strlen(out);
    if (len > 0) out[len-1] = '\0';

    printf("%s\n", out);
}