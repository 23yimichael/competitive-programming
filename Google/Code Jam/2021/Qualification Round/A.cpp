#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
#include <queue>
#include <deque>
#include <bitset>
#include <iterator>
#include <list>
#include <stack>
#include <map>
#include <set>
#include <functional>
#include <numeric>
#include <utility>
#include <limits>
#include <time.h>
#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>

#define ll long long
#define ld long double

using namespace std;

const bool debug = false;
const int mod = 1000000007;

int n, l[100];

void solve(int i, int j) {
    while(i<j){
        int temp = l[i];
        l[i]=l[j]; l[j]=temp;
        i++; j--;
    }
}

int main() {
  ios::sync_with_stdio(0); cin.tie(0);
  
  int t; cin >> t;
  for(int tc = 1; tc <= t; tc++) {
    cout << "Case #" << tc << ": ";
    cin >> n;
    for(int i = 0; i < n; i++) cin >> l[i];
    int ans = 0;
    for(int i = 1; i < n; i++) {
        for(int j = 1; j <= n; j++) {
            if(l[j-1]==i) {
                solve(i-1, j-1);
                ans+=j-i+1; 
                break;
            }
        }   
    }
    cout << ans << "\n";
    if(debug){
        cout << n << "\n";
        for(int i = 0; i < n; i++) cout << l[i] << " ";
        cout << "\n";
    }
  }
}
