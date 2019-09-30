#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>

using namespace std;

class Solution {
public:
    void gameOfLife(vector<vector<int>> &board) {
        int n = board.size();
        int m = board[0].size();
        vector<vector<int>> newBoard(n,vector<int>(m,0));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                if (i - 1 >= 0 && j - 1 >= 0) sum += board[i - 1][j - 1];
                if (i - 1 >= 0) sum += board[i - 1][j];
                if (i - 1 >= 0 && j + 1 < m) sum += board[i - 1][j + 1];
                if (j - 1 >= 0) sum += board[i][j - 1];
                if (j + 1 < m) sum += board[i][j + 1];
                if (i + 1 < n && j - 1 >= 0) sum += board[i + 1][j - 1];
                if (i + 1 < n) sum += board[i + 1][j];
                if (i + 1 < n && j + 1 < m) sum += board[i + 1][j + 1];

                switch (sum){
                    case 1: newBoard[i][j] = 0;           break;
                    case 2: newBoard[i][j] = board[i][j]; break;
                    case 3: newBoard[i][j] = 1;           break;
                    case 8: newBoard[i][j] = 0;           break;
                }
            }
        }
        board = newBoard;
    }
};

int main() {
    Solution s;
    vector<vector<int>> v = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    s.gameOfLife(v);
    for(int i=0;i<v.size();i++){
        for(int j=0;j<v[0].size();j++){
            cout<<v[i][j];
        }
        cout<<endl;
    }
}