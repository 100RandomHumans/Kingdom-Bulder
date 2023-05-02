import java.util.*;
public class Tile {
    //private Tile northEast, east, southEast, southWest, west, northWest;
    public String terrain, location;
    public Boolean hasHouse, toHighlight;
    public House house;
    public String houseColor;
    public int x, y, numTokensLeft;
    public ArrayList<String> usedPlayers;



    public Tile(String terrain, String location) {
        this.terrain = terrain;
        this.location = location;
        hasHouse = false;
        house = null;
        toHighlight = false;
        usedPlayers = new ArrayList<String>();

        if (location != null) {
            numTokensLeft = 2;
        }


    }

    public void setHighlight(Boolean h){
        toHighlight = h;
    }
    public String getTerrain(){
        return terrain;
    }

    public House getHouse(){
        return house;
    }

    public boolean getHasHouse(){return hasHouse;}
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
    public void setHasHouse(boolean que) {
        hasHouse = que;
    }
}
