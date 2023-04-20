import java.util.*;

public class Player {

    ArrayList<String> specialTokens;
    private int remainingHouses;
    private String color;
    private int score;
    private Boolean canPlaceHouse;

    public String card;

    public Player(String color) {
        score = 0;
        this.color = color;
        remainingHouses = 30;
        specialTokens = new ArrayList<>();
        fillSpecialToken();
        canPlaceHouse = false;
    }

    public House placeHouse(){
        remainingHouses = remainingHouses-1;
        return new House(color);
    }

    public void setCanPlaceHouse(Boolean b){
        canPlaceHouse = b;
    }
    public Boolean getCanPlaceHouse(){
        return canPlaceHouse;
    }
    public String getColor() {
        return color;
    }

    public int getHouseCount() {
        return remainingHouses;
    }

    public int getScore(){
        return score;
    }
    public void addSpecialToken(String token) {
        specialTokens.remove(specialTokens.size() - 1);
        specialTokens.add(0, token); // token must be in the form of Barn, Farm, Harbor...
    }
    public void fillSpecialToken() {
        for (int i = 0; i < 8; i++) {
            specialTokens.add("Empty");
        }

    }

}
