import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameLogic {
    String cardOne, cardTwo, cardThree;
    public boolean inGame, hoverInfo, endScreen;
    public final ArrayList<Player> players;
    public Player playerRed = new Player("Red");
    public Player playerBlue = new Player("Blue");
    public Player playerGreen = new Player("Green");
    public Player playerYellow = new Player("Yellow");
    public ArrayList<String> discardPile;
    public final ArrayList<String> scoreCards;
    public final ArrayList<String> terrainDeck;
    public Board board;
    public int housePlaced;
    public GameLogic() {
        players = new ArrayList<>();
        players.add(playerRed);
        players.add(playerBlue);
        players.add(playerGreen);
        players.add(playerYellow);

        board = new Board();
        terrainDeck = new ArrayList<>();
        scoreCards = new ArrayList<>();

        shuffleTerrainDeck();
        terrainDeck.add("Blank"); // This is because I write really shit code (Christopher)
        scoreCards.add("Fishermen");
        scoreCards.add("Merchant");
        scoreCards.add("Discoverer");
        scoreCards.add("Hermit");
        scoreCards.add("Citizen");
        scoreCards.add("Miner");
        scoreCards.add("Worker");
        scoreCards.add("Knight");
        scoreCards.add("Lord");
        scoreCards.add("Farmer");
        Collections.shuffle(scoreCards);
        cardOne = scoreCards.get(0);
        cardTwo = scoreCards.get(1);
        cardThree = scoreCards.get(2);

    }

    public void shuffleTerrainDeck() {
        for (int i = 0; i < 5; i++) {
            terrainDeck.add("Grass"); // Grass
            terrainDeck.add("Flower"); // Flower
            terrainDeck.add("Forest"); // Forest
            terrainDeck.add("Canyon"); // Canyon
            terrainDeck.add("Desert"); // Desert
        }
        Collections.shuffle(terrainDeck);
    }
    public Player findFirstPlayer() {
        switch ((int) (Math.random() * 4) + 1) {
            case 1 -> {
                return playerRed;
            }
            case 2 -> {
                return playerBlue;
            }
            case 3 -> {
                return playerGreen;
            }
            case 4 -> {
                return playerYellow;
            }
            default -> {
                return null;
            }
        }
    }


    public void addDiscardPile() {
        discardPile.add(terrainDeck.remove(0));
    }

    public void refillTerrainDeck() {
        if (discardPile.size() == 25) {
            for (int i = 0; i < 5; i++) { //Fills terrainDeck then shuffles it
                terrainDeck.add("P");
                terrainDeck.add("F");
                terrainDeck.add("T");
                terrainDeck.add("C");
                terrainDeck.add("D");
            }
            Map<String, String> map = new HashMap<String, String>();
            map.put("T", "Forest");
            map.put("M", "Mountain");
            map.put("P", "Grass");
            map.put("F", "Flower");
            map.put("W", "Water");
            map.put("D", "Desert");
            map.put("C", "Canyon");
            for (int i = 0; i < 25; i++) {
                terrainDeck.set(i, map.get(terrainDeck.get(i)));
            }
            Collections.shuffle(terrainDeck);
        }
    }

    public String getCardOne() {
        return cardOne;
    }

    public void setCardOne(String cardOne) {
        this.cardOne = cardOne;
    }

    public String getCardTwo() {
        return cardTwo;
    }

    public void setCardTwo(String cardTwo) {
        this.cardTwo = cardTwo;
    }

    public String getCardThree() {
        return cardThree;
    }

    public void setCardThree(String cardThree) {
        this.cardThree = cardThree;
    }



}
