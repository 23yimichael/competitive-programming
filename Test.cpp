#include <bits/stdc++.h>
using namespace std;

int64_t n, q, a, ps[500000];

int main() {
    ios::sync_with_stdio(0); cin.tie(0);

    cin >> n >> q;
    for(int64_t i = 0; i < n; i++) {
        cin >> a;
        ps[i+1] = ps[i]+a;
    } 
    for(int64_t i = 0; i < q; i++) {
        int64_t l, r;
        cin >> l >> r;
        cout << ps[r]-ps[l] << "\n";
    } 
}