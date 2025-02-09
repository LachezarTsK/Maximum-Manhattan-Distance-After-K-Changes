
using System;

public class Solution
{
    private const char EAST = 'E';
    private const char WEST = 'W';
    private const char SOUTH = 'S';
    private const char NORTH = 'N';

    private int eastDistance = 0;
    private int westDistance = 0;
    private int southDistance = 0;
    private int northDistance = 0;

    public int MaxDistance(string moves, int maxChange)
    {
        int maxDistance = 0;
        foreach (char move in moves)
        {
            UpdateDistanceForDirection(move);
            maxDistance = Math.Max(maxDistance, GetDistanceWithoutChange() + GetMaxIncreaseInDistance(maxChange));
        }
        return maxDistance;
    }

    private int GetDistanceWithoutChange()
    {
        return Math.Abs(eastDistance - westDistance) + Math.Abs(southDistance - northDistance);
    }

    private int GetMaxIncreaseInDistance(int maxChange)
    {
        int distanceIncrease = Math.Min(eastDistance, westDistance) + Math.Min(southDistance, northDistance);
        return 2 * Math.Min(distanceIncrease, maxChange);
    }

    private void UpdateDistanceForDirection(char direction)
    {
        switch (direction)
        {
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
                break;
        }
    }
}
