/*
/ Coded by Anas Azhar (anas.sty@gmail.com)
// a) the area of the rectangled triangle that has base A and height C.
// b) the area of the radius's circle C. (pi = 3.14159)
// c) the area of the trapezium which has A and B by base, and C by height.
// d) the area of ​​the square that has side B.
// e) the area of the rectangle that has sides A and B.
*/
#include <bits/stdc++.h>
using namespace std;
void solution()
{
    double A, B, C;
    cin >> A >> B >> C;
    cout << fixed << setprecision(3)
         << "TRIANGULO: " << 0.5*A*C << "\n"
         << "CIRCULO: " << 3.14159*C*C << "\n"
         << "TRAPEZIO: " << 0.5*(A+B)*C << "\n"
         << "QUADRADO: " << B*B << "\n"
         << "RETANGULO: " << A*B << "\n";

}
int main(int argc,char *args[])
{
    solution();
    return 0;
}