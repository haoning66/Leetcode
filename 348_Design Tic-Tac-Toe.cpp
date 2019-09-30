#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class TicTacToe {


public:


    TicTacToe(int n) {
        rowVector.resize(n, 0);
        colVector.resize(n, 0);
        diag = 0;
        andiag = 0;
    }

    int move(int row, int col, int player) {
        int add;
        int n = rowVector.size();
        if (player == 1)
            add = 1;
        else add = -1;
        rowVector[row] += add;
        colVector[col] += add;

        if (row == col)
            diag += add;
        if (row + col == n - 1)
            andiag += add;

        if (rowVector[row] == n || colVector[col] == n || rowVector[row] == -n || colVector[col] == -n || diag == n ||
            andiag == n || diag == -n || andiag == -n)
            return player;

        return 0;
    }

private:
    vector<int> rowVector;
    vector<int> colVector;
    int diag;
    int andiag;
};

int main() {
    vector<int> x;

    return 0;
}