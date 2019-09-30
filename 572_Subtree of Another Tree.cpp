#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isSubtree(TreeNode *s, TreeNode *t) {
        if(isIdentical(s,t)) return true;
        if(s==NULL || t==NULL) return false;
        return isSubtree(s->left,t)||isSubtree(s->right,t);
    }

    bool isIdentical(TreeNode *s, TreeNode *t) {
        if(s==NULL && t==NULL)
            return true;
        else if(s==NULL || t==NULL)
            return false;
        else{
            if (s->val == t->val) {
                return isIdentical(s->left, t->left) && isIdentical(s->right,t->right);
            }
            else return false;
        }
    }
};

int main() {
    Solution s;
    TreeNode a(1);
    TreeNode a1(1);
    TreeNode a2(2);
    a.left = &a1;
    a.right = &a2;

    TreeNode b(1);
    TreeNode b1(1);
    TreeNode b2(2);
    b.left = &b1;
    b.right = &b2;
    TreeNode *ap;
    ap = &a;
    TreeNode *bp;
    bp = &b;

    cout<<s.isIdentical(ap,bp);





}