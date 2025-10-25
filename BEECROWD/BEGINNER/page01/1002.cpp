#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    double R, A;
    cin >> R;
    A = 3.14159*R*R;
    cout << fixed << setprecision(4) << "A=" << A << "\n";
}