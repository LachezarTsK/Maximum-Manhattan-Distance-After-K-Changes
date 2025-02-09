
/**
 * @param {string} moves
 * @param {number} maxChange
 * @return {number}
 */
var maxDistance = function (moves, maxChange) {

    this.EAST = 'E';
    this.WEST = 'W';
    this.SOUTH = 'S';
    this.NORTH = 'N';

    this.eastDistance = 0;
    this.westDistance = 0;
    this.southDistance = 0;
    this.northDistance = 0;

    let maxDistance = 0;
    for (let move of moves) {
        updateDistanceForDirection(move);
        maxDistance = Math.max(maxDistance, getDistanceWithoutChange() + getMaxIncreaseInDistance(maxChange));
    }
    return maxDistance;
};

/**
 * @return {number}
 */
function getDistanceWithoutChange() {
    return Math.abs(this.eastDistance - this.westDistance) + Math.abs(this.southDistance - this.northDistance);
}

/**
 * @param {number} maxChange
 * @return {number}
 */
function getMaxIncreaseInDistance(maxChange) {
    const distanceIncrease = Math.min(this.eastDistance, this.westDistance) + Math.min(this.southDistance, this.northDistance);
    return 2 * Math.min(distanceIncrease, maxChange);
}

/**
 * @param {string} direction 
 * @return {void}
 */
function updateDistanceForDirection(direction) {
    switch (direction) {
        case this.EAST:
            ++this.eastDistance;
            break;
        case this.WEST:
            ++this.westDistance;
            break;
        case this.SOUTH :
            ++this.southDistance;
            break;
        case this.NORTH :
            ++this.northDistance;
    }
}
