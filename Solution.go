
package main

import "math"

const EAST = 'E'
const WEST = 'W'
const SOUTH = 'S'
const NORTH = 'N'

var eastDistance int
var westDistance int
var southDistance int
var northDistance int

func maxDistance(moves string, maxChange int) int {
    eastDistance = 0
    westDistance = 0
    southDistance = 0
    northDistance = 0

    maxDistance := 0
    for _, move := range moves {
        updateDistanceForDirection(move)
        maxDistance = max(maxDistance, getDistanceWithoutChange()+getMaxIncreaseInDistance(maxChange))
    }
    return maxDistance
}

func getDistanceWithoutChange() int {
    return int(math.Abs(float64(eastDistance-westDistance)) + math.Abs(float64(southDistance-northDistance)))
}

func getMaxIncreaseInDistance(maxChange int) int {
    distanceIncrease := min(eastDistance, westDistance) + min(southDistance, northDistance)
    return 2 * min(distanceIncrease, maxChange)
}

func updateDistanceForDirection(direction rune) {
    switch direction {
    case EAST:
        eastDistance++
        break
    case WEST:
        westDistance++
        break
    case SOUTH:
        southDistance++
        break
    case NORTH:
        northDistance++
    }
}
