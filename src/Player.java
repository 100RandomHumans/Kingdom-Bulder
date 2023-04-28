import java.util.*;

public class Player {

    ArrayList<String> specialTokens;
    public int remainingHouses;
    public String color;
    public int score;
    public String terrain;


    public Player(String color) {
        score = 0;
        this.color = color;
        remainingHouses = 40;
        specialTokens = new ArrayList<>();
        fillSpecialToken();
    }

    public House placeHouse(){
        remainingHouses = remainingHouses-1;
        return new House(color);
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
