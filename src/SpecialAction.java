import java.util.ArrayList;

public class SpecialAction {
    private String locationName;

    public SpecialAction(String specialTile) {
        locationName = specialTile;
    }

    public ArrayList<House> highliteHouse() {
        ArrayList<House> specialActionHouses = new ArrayList<House>();

        if(locationName.equals("Farm")) {

        } else if(locationName.equals("Harbor")) {

        } else if(locationName.equals("Oracle")) {

        } else if(locationName.equals("Tavern")) {

        }
    }
}
