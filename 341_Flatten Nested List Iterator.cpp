#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>
#include <stack>

using namespace std;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */

class NestedInteger {
public:
    bool isInteger() const;

    int getInteger() const;

    const vector<NestedInteger> &getList() const;
};

class NestedIterator {
public:
    NestedIterator(vector<NestedInteger> &nestedList) {
        for(int i=nestedList.size()-1; i>=0; i-- ){
            nestedStack.push(nestedList[i]);
        }
    }

    int next() {
        NestedInteger cur = nestedStack.top();
        nestedStack.pop();
        return cur.getInteger();
    }

    bool hasNext() {
        while(!nestedStack.empty()){
            NestedInteger cur = nestedStack.top();
            if(cur.isInteger())
                return true;
            nestedStack.pop();
            for(int i=cur.getList().size()-1;i>=0;i--){
                nestedStack.push(cur.getList()[i]);
            }
        }
        return false;
    }

private:
    stack<NestedInteger> nestedStack;
};

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i(nestedList);
 * while (i.hasNext()) cout << i.next();
 */

int main() {

}