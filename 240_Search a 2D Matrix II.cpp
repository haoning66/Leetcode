#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target) {
        if (matrix.size() == 0 || matrix[0].size()==0)
            return false;

        int x = 0;
        int y = matrix[0].size()-1;

        while(x<matrix.size()&&y>=0){
            if(matrix[x][y]==target)
                return true;
            else if(matrix[x][y]>target)
                y--;
            else
                x++;
        }
        return false;
    }

};


int main() {
    vector<vector<int>> matrix = {{1,  4,  7,  11, 15},
                                  {2,  5,  8,  12, 19},
                                  {3,  6,  9,  16, 22},
                                  {10, 13, 14, 17, 24},
                                  {18, 21, 23, 26, 30}};
    Solution s;
    cout << s.searchMatrix(matrix, 5) << endl;

    return 0;
}
