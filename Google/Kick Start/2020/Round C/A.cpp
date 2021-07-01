#include <bits/stdc++.h>
using namespace std;

int n, k, a[200000];

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin >> n >> k;
    for(int i = 0; i < n; i++) cin >> a[i];
    int cnt = 0;
    for(int i = 0; i < n; i++) {
      int temp = k;
      if(a[i]==temp){
        int j = i+1;
        temp--;
        while(j<n&&a[j]!=temp&&temp>=1){
          j++; temp--;
        }
        if(temp==1) {
          i=j;
          cnt++;
        }
      }
    }
    cout << cnt << "\n";
  }
}
