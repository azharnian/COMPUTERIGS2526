/*
/ Coded by Anas Azhar (anas.sty@gmail.com)
*/
#include <bits/stdc++.h>
using namespace std;
long max(long n, long m)
{
    return (n+m+abs(n-m))/2;
}
void solution()
{
    long a, b, c;
    cin >> a >> b >> c;
    cout << max(max(a ,b), c) << " eh o maior\n";
}
int main(int argc,char *args[])
{
    solution();
    return 0;
}