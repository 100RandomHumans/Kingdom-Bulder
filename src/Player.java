import java.util.*;

public class Player {
    ArrayList<String> specialTokens;
    ArrayList<Houses> Houses;
    private int remainingHouses;
    private String color;
    private int score;

    public Player(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getHouseCount() {
        return remainingHouses;
    }

    public void addSpecialToken(String token) {
        specialTokens = new ArrayList<>();
        specialTokens.add(token);
    }
}
