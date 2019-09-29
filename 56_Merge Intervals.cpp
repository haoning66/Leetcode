#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(const vector<int> &a, const vector<int> &b) {
    return a[0] < b[0];
}

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end(),cmp);
        vector<vector<int>> res;
        for(int i=0;i<intervals.size();i++){
            if(i==0){
                res.push_back(intervals[i]);
            }
            if(intervals[i][0]>res.back()[1])
                res.push_back(intervals[i]);
            else{
                res.back()[1] = max(res.back()[1],intervals[i][1]);
            }
        }
        return res;
    }
};

int main() {
    Solution s;
    vector<vector<int>> a = {{1,3},{2,6},{8,10},{15,18}};
    vector<vector<int>> v = s.merge(a);



    for(int i=0;i<v.size();i++){
        cout<<v[i][1]<<endl;
    }

    return 0;
}