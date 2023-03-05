public class Tile {
    public Tile northEast, east, southEast, southWest, west, northWest;
    String terrain;
    public int x, y;

    public Tile() {

    }
    public Tile getNorthEast() {
        return northEast;
    }

    public void setNorthEast(Tile northEast) {
        this.northEast = northEast;
    }

    public Tile getEast() {
        return east;
    }

    public void setEast(Tile east) {
        this.east = east;
    }

    public Tile getSouthEast() {
        return southEast;
    }

    public void setSouthEast(Tile southEast) {
        this.southEast = southEast;
    }

    public Tile getSouthWest() {
        return southWest;
    }

    public void setSouthWest(Tile southWest) {
        this.southWest = southWest;
    }

    public Tile getWest() {
        return west;
    }

    public void setWest(Tile west) {
        this.west = west;
    }

    public Tile getNorthWest() {
        return northWest;
    }

    public void setNorthWest(Tile northWest) {
        this.northWest = northWest;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
}
