import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> map = new HashMap<String, String>();
        map.put("T", "Forest");map.put("M", "Mountain");map.put("P", "Grass");map.put("F", "Flower");map.put("W", "Water");map.put("D", "Desert"); map.put("C", "Canyon");
        for(int i = 0; i < 25; i++){
            terrainDeck.set(i, map.get(terrainDeck.get(i)));
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
            Map<String, String> map = new HashMap<String, String>();
            map.put("T", "Forest");map.put("M", "Mountain");map.put("P", "Grass");map.put("F", "Flower");map.put("W", "Water");map.put("D", "Desert"); map.put("C", "Canyon");
            for(int i = 0; i < 25; i++){
                terrainDeck.set(i, map.get(terrainDeck.get(i)));
            }
            Collections.shuffle(terrainDeck);
        }
    }
}
