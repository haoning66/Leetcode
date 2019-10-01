#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>
#include <stack>

using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int> &nums) {
        vector<int> stack;      //dont actually use a stack unless necessary, stack is big
        int len = nums.size();
        vector<int> result(len, -1);
        for (int i = 0; i < len * 2; i++) {
            while (!stack.empty() && nums[stack.back()] < nums[i % len]) {   //this loop will go on until it pops all the elements in the stack that is smaller than it
                result[stack.back()] = nums[i%len];
                stack.pop_back();
            }
            stack.push_back(i%len);
        }
        return result;


//        int n = nums.size();
//        vector<int> result(n);
//        if (n == 0)
//            return result;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                if (j == n)
//                    j = 0;
//
//                if (nums[j] > nums[i]) {
//                    result[i] = nums[j];      //stupid two for-loops index manipulation solution, so slow
//                    break;
//                }
//
//                if (j == i) {
//                    result[i] = -1;
//                    break;
//                }
//            }
//        }
//        return result;
    }

};

int main() {
    vector<int> nums = {1, 2, 1};
    vector<int> result;
    Solution s;
    result = s.nextGreaterElements(nums);

    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << endl;
    }


}