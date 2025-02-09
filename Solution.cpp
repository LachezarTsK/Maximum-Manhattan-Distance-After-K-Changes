
#include <cmath>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

    static const char EAST = 'E';
    static const char WEST = 'W';
    static const char SOUTH = 'S';
    static const char NORTH = 'N';

    int eastDistance = 0;
    int westDistance = 0;
    int southDistance = 0;
    int northDistance = 0;

public:
    int maxDistance(const string& moves, int maxChange) {
        int maxDistance = 0;
        for (const auto& move : moves) {
            updateDistanceForDirection(move);
            maxDistance = max(maxDistance, getDistanceWithoutChange() + getMaxIncreaseInDistance(maxChange));
        }
        return maxDistance;
    }

private:
    int getDistanceWithoutChange() const {
        return abs(eastDistance - westDistance) + abs(southDistance - northDistance);
    }

    int getMaxIncreaseInDistance(int maxChange) const {
        int distanceIncrease = min(eastDistance, westDistance) + min(southDistance, northDistance);
        return 2 * min(distanceIncrease, maxChange);
    }   

    void updateDistanceForDirection(char direction) {
        switch (direction) {
            case EAST:
                ++eastDistance;
                break;
            case WEST:
                ++westDistance;
                break;
            case SOUTH:
                ++southDistance;
                break;
            case NORTH:
                ++northDistance;
        }
    }
};
