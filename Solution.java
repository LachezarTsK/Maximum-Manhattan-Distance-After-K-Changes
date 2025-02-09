
public class Solution {

    private static final char EAST = 'E';
    private static final char WEST = 'W';
    private static final char SOUTH = 'S';
    private static final char NORTH = 'N';

    private int eastDistance = 0;
    private int westDistance = 0;
    private int southDistance = 0;
    private int northDistance = 0;

    public int maxDistance(String moves, int maxChange) {
        int maxDistance = 0;
        for (char move : moves.toCharArray()) {
            updateDistanceForDirection(move);
            maxDistance = Math.max(maxDistance, getDistanceWithoutChange() + getMaxIncreaseInDistance(maxChange));
        }
        return maxDistance;
    }

    private int getDistanceWithoutChange() {
        return Math.abs(eastDistance - westDistance) + Math.abs(southDistance - northDistance);
    }

    private int getMaxIncreaseInDistance(int maxChange) {
        int distanceIncrease = Math.min(eastDistance, westDistance) + Math.min(southDistance, northDistance);
        return 2 * Math.min(distanceIncrease, maxChange);
    }

    private void updateDistanceForDirection(char direction) {
        // 'Rule switch', applied here, does not need break statements.
        switch (direction) {
            case EAST ->
                ++eastDistance;
            case WEST ->
                ++westDistance;
            case SOUTH ->
                ++southDistance;
            case NORTH ->
                ++northDistance;
        }
    }
}
