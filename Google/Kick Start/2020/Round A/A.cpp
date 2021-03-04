#include <iostream>
#include <algorithm>

using namespace std;

int n, b, a[100000];

void solve() {
    cin >> n >> b;
    for(int i = 0; i < n; i++) cin >> a[i];
    sort(a, a+n);
    int s = 0, cnt = 0;
    for(int i = 0; i < n; i++) {
        s+=a[i];
        if(s>b) break;
        cnt++;
    }
    cout << cnt << "\n";
}

int main() {
    int t;
    cin >> t;
    for(int i = 1; i <= t; i++) {
        cout << "Case #" << i << ": ";
        solve();
    }
}
