#include <iostream>

using namespace std;

int n, a[100];

void solve() {
    int cnt = 0;
    cin >> n;
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 1; i < n-1; i++)
        if(a[i]>a[i-1]&&a[i]>a[i+1]) cnt++;
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
