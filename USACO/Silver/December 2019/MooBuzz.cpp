#include <iostream>
#include <fstream>

using namespace std;

int n, a[] = {1, 2, 4, 7, 8, 11, 13, 14};

int main() {
    ifstream fin ("moobuzz.in");
    ofstream fout ("moobuzz.out");

    fin >> n;
    fout << (n/8*15)+a[n%8-1];
}
