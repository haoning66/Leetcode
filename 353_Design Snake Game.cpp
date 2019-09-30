#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>

using namespace std;

class SnakeGame {
public:
    SnakeGame(int width, int height, vector<vector<int>> &food) {
        w = width;
        h = height;
        food_cnt = 0;
        foodV = food;
        snakebody.push_front(make_pair(0, 0));
    }

    int move(string direction) {
        int x = snakebody.front().first;
        int y = snakebody.front().second;

        if (direction == "U") x--;
        if (direction == "D") x++;
        if (direction == "L") y--;
        if (direction == "R") y++;

        if (x < 0 || x >= h || y < 0 || y >= w)
            return -1;

        pair<int, int> temp = make_pair(x, y);
        if (find(snakebody.begin(), snakebody.end(), temp) !=
            snakebody.end()) {   //if it cannot find temp in snakebody queue, it will return snakebody.end(),if the condition is true that means temp is already in snakebody
            if (temp != snakebody.back())
                return -1;  //because the snake is moving forward, if the new position is where the tail is then it will not bite its body, because tail also moves forward
        }

        if (food_cnt < foodV.size() && x == foodV[food_cnt][0] && y == foodV[food_cnt][1]) {
            food_cnt++;
        }
        else snakebody.pop_back();      //this is because when the snake gets the food the food will be come the new head of the snake, its tail will remain in its position, no need to pop the tail
        snakebody.push_front(temp);
        return food_cnt;
    }


private:
    int w;
    int h;
    int food_cnt;
    vector<vector<int>> foodV;
    deque<pair<int, int>> snakebody;

};

int main() {
    vector<vector<int>> food = {{1, 2},
                                {0, 1}};

//    SnakeGame s(3,2,food);
//
//    cout<<s.move("R")<<endl;
//    cout<<s.move("D")<<endl;
//    cout<<s.move("R")<<endl;
//    cout<<s.move("U")<<endl;
//    cout<<s.move("L")<<endl;
//    cout<<s.move("U")<<endl;



}