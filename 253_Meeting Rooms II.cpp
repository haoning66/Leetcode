#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

bool cmp(const vector<int> &a, const vector<int> &b) {
    return a[0] < b[0];
}

struct endCompare{
    bool operator ()(vector<int> &a, vector<int> &b) {
        return a[1] >= b[1];
    }
};


class Solution {
public:
    int minMeetingRooms(vector<vector<int>> &intervals) {
        sort(intervals.begin(), intervals.end(), cmp);
        priority_queue<vector<int>, vector<vector<int>>, endCompare>  pq;
        for (int i = 0; i < intervals.size(); i++) {
            if (!pq.empty() && intervals[i][0] >= pq.top()[1]){
                pq.pop();
            }
            pq.push(intervals[i]);
        }
        return pq.size();
    }
};

int main() {
    Solution s;
    vector<vector<int>> interval = {{0,  30},
                                    {5,  10},
                                    {15, 20}};
    cout<< s.minMeetingRooms(interval)<<endl;
    return 0;
}