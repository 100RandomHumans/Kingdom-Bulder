import java.util.ArrayList;

public class GameState {
    public int gameState;
    public GameLogic gameLogic;
    public int firstTurn;
    public int turnNum;
    public String scene;
    public Player firstPlayer;
    public Player currentPlayer;
    public ArrayList<String> avilableTiles;

    public GameState(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        startGame();
    }

    public void setScene(int sceneState) {
        if (sceneState == 0) {
            scene = "playScreen";
        } else if (sceneState == 1) {
            scene = "endScreen";
        }
    }

    public String getScene() {
        return scene;
    }

    public void startGame() {
        firstPlayer = gameLogic.findFirstPlayer();
        currentPlayer = firstPlayer;
        gameState = 1;
        setScene(gameState);
        setTurnNum(gameLogic.players.indexOf(firstPlayer));
        nextTurn();
    }


    public void nextTurn() {
        avilableTiles = new ArrayList<>();
        if (turnNum == 4) {
            turnNum = 1;
        } else {
            turnNum++;
        }
        currentPlayer = gameLogic.players.get(turnNum - 1);

        currentPlayer.terrain = gameLogic.terrainDeck.remove(0);
        System.out.println(gameLogic.terrainDeck.size());
        if (gameLogic.terrainDeck.size() == 0) {
            gameLogic.shuffleTerrainDeck();
        }
        gameLogic.housePlaced = 0;
        gameState = 1;
        for (int i = 0; i < 8; i++){
            avilableTiles.add(currentPlayer.specialTokens.get(i));
        }

    }

    public void endGame() {
        gameState = 1;
        setScene(gameState);
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public int getFirstTurn() {
        return firstTurn;
    }

    public void setFirstTurn(int firstTurn) {
        this.firstTurn = firstTurn;
    }

    public int getTurnNum() {
        return turnNum;
    }

    public void setTurnNum(int turnNum) {
        this.turnNum = turnNum;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
