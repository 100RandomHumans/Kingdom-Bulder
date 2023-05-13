import java.util.*;

public class Player {

    ArrayList<String> specialTokens;
    public int remainingHouses;
    public String color;
    public int score;
    public String terrain;
    int count;
    int placement;
    public Player(String color) {
        score = 0;
        count = 0;
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
        for (int i = 0; i < specialTokens.size(); i++) {
            if (specialTokens.get(i).equals("Empty")) {
                specialTokens.set(i, token);
                break;
            }
        }
        count++;
    }
    public void fillSpecialToken() {
        for (int i = 0; i < 8; i++) {
            specialTokens.add("Empty");
        }
    }

    public void removeSpecialToken(String token) {
        specialTokens.remove(token);
        count--;
    }

    @Override
    public String toString() {
        return "Player{" +
                "color='" + color + '\'' +
                ", score=" + score +
                ", placement=" + placement +
                '}';
    }
}
