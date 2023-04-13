import java.util.*;

public class Player {

    ArrayList<String> specialTokens;
    private int remainingHouses;
    private String color;
    private int score;

    public Player(String color) {
        score = 0;
        this.color = color;
        remainingHouses = 30;
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
        specialTokens = new ArrayList<>();
        specialTokens.add(token);
    }
}
