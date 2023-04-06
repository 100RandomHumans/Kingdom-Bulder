import java.util.ArrayList;
import java.util.Collections;

public class GameLogic {
    private boolean inGame, hoverInfo, endScreen;
    private ArrayList<Player> players;
    private ArrayList<String> scoreCards, terrainDeck, discardPile;
    public GameLogic() {
        for (int i = 0; i < 5; i++) {
            terrainDeck.add("P");
            terrainDeck.add("F");
            terrainDeck.add("T");
            terrainDeck.add("C");
            terrainDeck.add("D");
        }
        Collections.shuffle(terrainDeck);
        scoreCards.add("Fishermen");
        scoreCards.add("Merchants");
        scoreCards.add("Discoverers");
        scoreCards.add("Hermits");
        scoreCards.add("Citizens");
        scoreCards.add("Miners");
        scoreCards.add("Workers");
        scoreCards.add("Knights");
        scoreCards.add("Lords");
        scoreCards.add("Farmers");

    }
    public String findFirstPlayer() {
        return "Player" + ((int)(Math.random() * 4) + 1);
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
            Collections.shuffle(terrainDeck);
        }
    }

}
