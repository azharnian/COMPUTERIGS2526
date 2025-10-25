/*
/ Coded by Anas Azhar (anas.sty@gmail.com)
*/
#include <bits/stdc++.h>
using namespace std;
void solution()
{
    double x1, y1, x2, y2;
    cin >> x1 >> y1 
        >> x2 >> y2;
    cout << fixed << setprecision(4) 
        << sqrt(pow((x2-x1), 2) + pow((y2-y1) ,2)) << "\n";
}
int main(int argc,char *args[])
{
    solution();
    return 0;
}