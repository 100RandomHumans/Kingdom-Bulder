public class Tile {
    //private Tile northEast, east, southEast, southWest, west, northWest;
    private String terrain, location;
    private Boolean hasHouse;
    private House house;

    public Tile(String terrain, String location) {
        this.terrain = terrain;
        this.location = location;
        hasHouse = false;
        house = null;
    }

    public String getTerrain(){
        return terrain;
    }

    public String getLocation(){
        return location;
    }

    public void changeTerrain(String t){
        terrain = t;
    }

    public void changeLocation(String l){
        location = l;
    }
    public String toString(){
        return (terrain + "" + location);
    }
}
