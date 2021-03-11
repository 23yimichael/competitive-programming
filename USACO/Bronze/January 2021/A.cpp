#include <bits/stdc++.h>

using namespace std;

string a, s;
queue<char> q;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> a;
    cin >> s;
    for(int i = 0; i < s.size(); i++) q.push(s[i]);
    int cnt = 0;
    while(!q.empty()){
        for(char c : a){if(c==q.front()) q.pop();}
        cnt++;
    }
    cout << cnt;
}
