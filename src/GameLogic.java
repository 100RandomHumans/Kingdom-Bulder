import java.util.ArrayList;

public class GameLogic {
    private boolean inGame, hoverInfo, endScreen;
    private ArrayList<Player> players;
    private ArrayList<String> scoreCards, terrainDeck, discardPile;
    public GameLogic() {
        for (int i = 0; i < 5; i++) { //Fills terrainDeck not randomly
            terrainDeck.add("P");
            terrainDeck.add("F");
            terrainDeck.add("T");
            terrainDeck.add("C");
            terrainDeck.add("D");
        }
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
    public String findFirstPlayer() { return null; }
    public void addDiscardPile() {}
    public void refillTerrainDeck() {}

}
