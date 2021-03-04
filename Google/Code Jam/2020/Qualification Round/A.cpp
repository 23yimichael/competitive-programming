#include <iostream>
#include <set>

using namespace std;

int n, a[100][100];

void solve() {
    cin >> n;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < n; j++) cin >> a[i][j];
    int k=0, r=0, c=0;
    for(int i = 0; i < n; i++) k+=a[i][i]; 
    set<int> s;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(s.count(a[i][j])==1) { 
                r++;
                break;
            }
            s.insert(a[i][j]);
        }
        s.clear();
    }
    for(int j = 0; j < n; j++) {
        for(int i = 0; i < n; i++) {
            if(s.count(a[i][j])==1) { 
                c++;
                break;
            }
            s.insert(a[i][j]);
        }
        s.clear();
    }
    cout << k << " " << r << " " << c << "\n";  
}

int main() {
    int t;
    cin >> t;
    for(int i = 1; i<=t; i++){
        cout << "Case #" << i << ": ";
        solve();
    }
}
