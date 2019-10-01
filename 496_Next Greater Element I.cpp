#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>
#include <stack>

using namespace std;

class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        vector<int> result(nums1.size(),-1);
        for(int i=0;i<nums1.size();i++){
            vector <int>::iterator iter = find(nums2.begin(),nums2.end(),nums1[i]);
            int pos = distance(nums2.begin(),iter);
            for(int j=pos;j<nums2.size();j++){
                if(nums2[j]>nums1[i]){
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }

};

int main() {
    vector<int> nums = {1, 2, 3};
    vector <int>::iterator ele= find(nums.begin(),nums.end(),3);
    cout<<distance(nums.begin(),ele);


}