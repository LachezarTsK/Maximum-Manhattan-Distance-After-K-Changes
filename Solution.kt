
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Solution {

    private companion object {
        const val EAST = 'E'
        const val WEST = 'W'
        const val SOUTH = 'S'
        const val NORTH = 'N'
    }

    private var eastDistance = 0
    private var westDistance = 0
    private var southDistance = 0
    private var northDistance = 0

    fun maxDistance(moves: String, maxChange: Int): Int {
        var maxDistance = 0
        for (move in moves) {
            updateDistanceForDirection(move)
            maxDistance = max(maxDistance, getDistanceWithoutChange() + getMaxIncreaseInDistance(maxChange))
        }
        return maxDistance
    }

    private fun getDistanceWithoutChange(): Int {
        return abs(eastDistance - westDistance) + abs(southDistance - northDistance)
    }

    private fun getMaxIncreaseInDistance(maxChange: Int): Int {
        val distanceIncrease = min(eastDistance, westDistance) + min(southDistance, northDistance)
        return 2 * min(distanceIncrease, maxChange)
    }

    private fun updateDistanceForDirection(direction: Char) {
        when (direction) {
            EAST -> ++eastDistance
            WEST -> ++westDistance
            SOUTH -> ++southDistance
            NORTH -> ++northDistance
        }
    }
}
